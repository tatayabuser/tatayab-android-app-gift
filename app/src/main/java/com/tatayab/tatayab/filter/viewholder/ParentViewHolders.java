package com.tatayab.tatayab.filter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.tatayab.tatayab.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ParentViewHolders extends GroupViewHolder {

    public AppCompatTextView textView_parent;

    public ParentViewHolders(View itemView) {
        super(itemView);
       // textView_parent = itemView.findViewById(R.id.tv_filter_parent_title);
    }

    @Override
    public void expand() {
        super.expand();
        textView_parent.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.arrow_up_layer,0);
    }

    @Override
    public void collapse() {
        super.collapse();
        textView_parent.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_down_layer,0);
    }

    public void setGroupName(ExpandableGroup groupName){
        textView_parent.setText(groupName.getTitle());
    }
}