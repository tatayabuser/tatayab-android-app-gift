package com.tatayab.tatayab.filter.viewholder;

import android.view.View;
import android.widget.Checkable;

import androidx.appcompat.widget.AppCompatCheckedTextView;

import com.tatayab.tatayab.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

public class ChildViewHolders extends CheckableChildViewHolder {

    public AppCompatCheckedTextView textView_child;

    public ChildViewHolders(View itemView) {
        super(itemView);
        textView_child = itemView.findViewById(R.id.tv_filter_value);
    }

    @Override
    public Checkable getCheckable() {
        return textView_child;
    }

    public void setChildText(String name){
        textView_child.setText(name);
    }
}