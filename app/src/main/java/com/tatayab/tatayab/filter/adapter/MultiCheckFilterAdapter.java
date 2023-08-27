//package com.tatayab.tatayab.filter.adapter;
//
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.tatayab.model.filter.ChildData;
//import com.tatayab.model.filter.Variant;
//import com.tatayab.tatayab.R;
//import com.tatayab.model.filter.ParentData;
//import com.tatayab.tatayab.filter.viewholder.ChildViewHolders;
//import com.tatayab.tatayab.filter.viewholder.ParentViewHolders;
//import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
//import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
//import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
//
//import java.util.List;
//
//public class MultiCheckFilterAdapter extends CheckableChildRecyclerViewAdapter<ParentViewHolders, ChildViewHolders> {
//
//    public MultiCheckFilterAdapter(List<ParentData> groups) {
//        super(groups);
//    }
//
//    @Override
//    public ChildViewHolders onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item_child_filter, parent, false);
//        return new ChildViewHolders(view);
//    }
//
//    @Override
//    public void onBindCheckChildViewHolder(ChildViewHolders holder, int position,
//                                           CheckedExpandableGroup group, int childIndex) {
//        final ChildData item = (ChildData) group.getItems().get(childIndex);
//        holder.setChildText(item.getName());
//    }
//
//    @Override
//    public ParentViewHolders onCreateGroupViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item_parent_filter, parent, false);
//        return new ParentViewHolders(view);
//    }
//
//    @Override
//    public void onBindGroupViewHolder(ParentViewHolders holder, int flatPosition,
//                                      ExpandableGroup group) {
//        holder.setGroupName(group);
//    }
//}