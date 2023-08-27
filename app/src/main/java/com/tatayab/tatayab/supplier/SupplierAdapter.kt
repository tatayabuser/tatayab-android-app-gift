package com.tatayab.tatayab.supplier

import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SectionIndexer
 import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.tatayab.R
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSupplierListener

class SupplierAdapter(
    val listener: OnSupplierListener,
    val mSuppliersList: List<SupplierResponse>,
    val mContext: Context
) : RecyclerView.Adapter<SupplierAdapter.BrandViewHolder>(),
    SectionIndexer {

    private var mSectionPositions: ArrayList<Int> = ArrayList()
    private var sections = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_brand, null)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val data = mSuppliersList.get(position)
        data.name.let {
            holder.title.setText(it + "")
        }
        if(data?.image == null || data.image.isNullOrBlank()){
//            Glide.with(mContext)
//                .load(R.drawable.app_icon)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.brandProfileIcon)
            holder.brandProfileIcon.visibility = View.INVISIBLE
        }else{
            holder.brandProfileIcon.visibility = View.VISIBLE
//            Glide.with(mContext)
//                .load(data?.image)
//                .apply(RequestOptions.circleCropTransform())
//                .into(holder.brandProfileIcon)

            try {
                Picasso.get()
                    .load( data?.image)
                    .placeholder(R.drawable.default_image2).into(holder.brandProfileIcon)

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        var indax = positionIsExitsInSectionsList(position)
        if(indax == -1){
            holder.header.visibility = View.GONE
        }else{
            holder.header.visibility = View.VISIBLE
            holder.header.text = sections[indax]
        }

        holder.title.setSafeOnClickListener {
            if(!data?.supplierId.isNullOrBlank()) {
                listener.onSupplierSelected(
                    data.supplierId,
                    if(data.name.isNullOrBlank()) " " else data.name
                )
            }
        }

    }


    fun positionIsExitsInSectionsList(position: Int): Int {
        for ((i, index) in mSectionPositions.withIndex()) {
            if (position == index)
                return i
        }
        return -1
    }

    override fun getItemCount(): Int {
        return mSuppliersList!!.size
    }

    override fun getSections(): Array<String> {
        sections = ArrayList<String>()
        mSectionPositions = ArrayList()
        var i = 0
        val size = mSuppliersList!!.size
        while (i < size) {
            if (!mSuppliersList.get(i).name.isNullOrEmpty()) {
                var section = (mSuppliersList.get(i).name.get(0)).toString()
                if (!isLetters(section)) {
                    section = "#"
                }
                if (!isArabicChar(section)) {
                    section = section.toUpperCase()
                }
                if (!sections.contains(section)) {
                    sections.add(section)
                    mSectionPositions.add(i)
                }
            }
            i++

        }
        return sections.toTypedArray()
    }

    fun isLetters(char:  String): Boolean {
        return char.filter { it in 'A'..'Z' || it in 'a'..'z'}.length == char.length || isArabicChar(char)
    }

    private fun isArabicChar(chr: String): Boolean {
        val c = chr.codePointAt(0)
        if (c >= 0x0600 && c <= 0x06E0)
            return true

        return false
    }


    override fun getPositionForSection(i: Int): Int {
        return mSectionPositions[i]
    }

    override fun getSectionForPosition(i: Int): Int {
        return mSectionPositions[i]
    }

    operator fun compareTo(o: Any): Int {
        return 0
    }

    inner class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var header: TextView
        var brandProfileIcon: ImageView

        init {
            title = itemView.findViewById(R.id.brandTitleTextView)
            header = itemView.findViewById(R.id.brandHederTextView)
            brandProfileIcon = itemView.findViewById(R.id.brandProfileIcon)
         }



    }


}