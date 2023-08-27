package com.tatayab.tatayab.main.cart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase
import com.tatayab.presentation.main.cart.ReferCartFriendViewModel
import com.tatayab.presentation.main.cart.ReferCartFriendViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_refer_cart.*
 import kotlinx.android.synthetic.main.toolbar_with_back.*
import javax.inject.Inject


class ReferCartFragment : BaseFragment2() {

    private lateinit var viewModel: ReferCartFriendViewModel

    @Inject
    lateinit var viewModelFactory: ReferCartFriendViewModelFactory.Factory

    var currency: String? = null
    override fun layoutId(): Int {
        return R.layout.fragment_refer_cart
    }

    private val cartListItems by lazy {
        arguments?.let {
            ReferCartFragmentArgs.fromBundle(
                it
            ).cartListItems
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(ReferCartFriendViewModel::class.java)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()
     }

    private fun intComponent() {
        tv_title.text = getString(R.string.share_cart)
        iv_back.setOnClickListener {
            findNavController().popBackStack()
        }
        shareCartButton.setSafeOnClickListener {
            if(!cartListItems.isNullOrEmpty())shareCartWithFriend(viewModel.getUserId(), viewModel.getUserName(),cartListItems!!)
        }
    }

    fun shareCartWithFriend(userId: String, userName: String,cartItems:String) {
        try {

            val shortLinkTask = Firebase.dynamicLinks.shortLinkAsync {
                 val dataEncoded=  Uri.encode(cartItems, "UTF-8")
                link = Uri.parse("https://tatayab.com/share_cart?params=$dataEncoded")
                println("Share Cart: https://tatayab.com/share_cart?param="+cartItems)
                println("Share Cart encoded: "+link)
                domainUriPrefix = "https://tatayab.page.link"
                // Open links with this app on Android
                androidParameters("com.tatayab.tatayab.dev") {
                }
                // Open links with com.example.ios on iOS
                iosParameters("com.tatayab.tatayab") {
                    appStoreId = "1394093760"
                }
            }.addOnSuccessListener { (shortLink, flowchartLink) ->
                println("Share Cart shortLink: " + shortLink)
                if (!shortLink.toString().isNullOrEmpty())
                    shareCartToFriends(shortLink.toString(), userName)
            }.addOnFailureListener {
                println("Akl: shortLink/error: " + it.localizedMessage)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun shareCartToFriends(shortLink: String, userName: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        //wail Izz Al Mohammad  invited you to use Tatayab App, and you will git 5KD as a gift in your first order
        val shareBody = userName.plus(
            "\n" + String.format(
                resources.getString(R.string.share_cart_description)
            ).plus(" $shortLink\n")
        )
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.app_name))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_using)))
    }

}
