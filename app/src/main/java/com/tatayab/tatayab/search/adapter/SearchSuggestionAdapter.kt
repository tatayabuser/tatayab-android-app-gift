package com.tatayab.tatayab.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.SearchModel
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSearchListener
import kotlinx.android.synthetic.main.item_search_suggestion.view.*

class SearchSuggestionAdapter(
    private val listener: OnSearchListener
) : RecyclerView.Adapter<SearchSuggestionAdapter.SearchSuggestionViewHolder>() {

    override fun getItemCount(): Int {
        return if (items?.size!! > 0) {
            if (items?.size!! > 4) {
                4
            } else {
                items?.size!!
            }
        } else {
            0
        }
    }

    private var items = ArrayList<SearchModel>()

    override fun onBindViewHolder(holder: SearchSuggestionViewHolder, position: Int) {
        if (items.isNullOrEmpty() || items?.size!! <= position) return
        val searchText = items?.get(position)
        with(holder) {
            bindTo(searchText!!)
            searchText?.let { searchModel ->
                itemView.setSafeOnClickListener {
                    listener?.onSearchSuggestionSelected(searchModel.searchText)
                }
                removeImageView.setSafeOnClickListener {
                    items?.removeAt(position)
                    notifyDataSetChanged()
                    listener?.onRemovedSuggestionClicked(position)
                }
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchSuggestionViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search_suggestion, parent, false)

        return SearchSuggestionViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun setData(items: List<SearchModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    inner class SearchSuggestionViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        private val searchTitleTextView = view.searchTitleTextView
        val removeImageView = view.removeImageView
        private var context = view.context

        private var mSearchModel: SearchModel? = null
        fun bindTo(searchmodel: SearchModel) {
            this.mSearchModel = searchmodel
            mSearchModel?.let {
                searchTitleTextView.text = it.searchText
            }

        }
    }


}