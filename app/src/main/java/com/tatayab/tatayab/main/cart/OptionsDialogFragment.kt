package com.tatayab.tatayab.main.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnSelectedOptionListener
import kotlinx.android.synthetic.main.dialog_options.*

class OptionsDialogFragment : DialogFragment(), OnSelectedOptionListener {

    private val product by lazy {
        arguments?.let {
            OptionsDialogFragmentArgs.fromBundle(
                it
            ).optionItems
        }
    }
    private var optionsAdapter: OptionsAdapter = OptionsAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog?.setOnShowListener {
            dialog?.setTitle(getString(R.string.options))
            dialog?.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_options, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_options.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        rv_options.adapter = optionsAdapter
        optionsAdapter.setData(product?.productOptionsDetailed?.toMutableMap())
    }


    override fun onSelectedOptionClicked(value: String) {
    }

    companion object {
        fun newInstance(num: Int): OptionsDialogFragment {
            val f = OptionsDialogFragment()
            // Supply num input as an argument.
            val args = Bundle()
            args.putInt("num", num)
            f.arguments = args
            return f
        }
    }

}