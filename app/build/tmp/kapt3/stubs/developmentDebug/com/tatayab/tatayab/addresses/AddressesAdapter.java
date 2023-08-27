package com.tatayab.tatayab.addresses;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\u00102\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ,\u0010\u001d\u001a\u00020\u00102\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tatayab/tatayab/addresses/AddressesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/addresses/AddressesAdapter$AddressViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnAddressListener;", "(Lcom/tatayab/tatayab/listener/OnAddressListener;)V", "addressType", "", "Lcom/tatayab/model/addresses/AddressType;", "areaText", "", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/requests/AddressRequest;", "Lkotlin/collections/ArrayList;", "changePrimary", "", "CurrentPosition", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAreaText", "setData", "types", "setRemoveItem", "index", "AddressViewHolder", "app_developmentDebug"})
public final class AddressesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.addresses.AddressesAdapter.AddressViewHolder> {
    private final com.tatayab.tatayab.listener.OnAddressListener listener = null;
    private java.util.ArrayList<com.tatayab.model.requests.AddressRequest> items;
    private java.lang.String areaText = "";
    private java.util.List<com.tatayab.model.addresses.AddressType> addressType;
    
    public AddressesAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnAddressListener listener) {
        super();
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void changePrimary(int CurrentPosition) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.addresses.AddressesAdapter.AddressViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.addresses.AddressesAdapter.AddressViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setAreaText(@org.jetbrains.annotations.NotNull
    java.lang.String areaText) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.requests.AddressRequest> items, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.addresses.AddressType> types) {
    }
    
    public final void setRemoveItem(int index) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tatayab/tatayab/addresses/AddressesAdapter$AddressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/addresses/AddressesAdapter;Landroid/view/View;)V", "address", "Lcom/tatayab/model/requests/AddressRequest;", "getAddress", "()Lcom/tatayab/model/requests/AddressRequest;", "setAddress", "(Lcom/tatayab/model/requests/AddressRequest;)V", "area", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", "city", "delete", "edit", "isDefault", "Landroid/widget/ImageView;", "name", "phone", "bindTo", "", "app_developmentDebug"})
    public final class AddressViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.appcompat.widget.AppCompatTextView name = null;
        private final androidx.appcompat.widget.AppCompatTextView city = null;
        private final androidx.appcompat.widget.AppCompatTextView area = null;
        private final androidx.appcompat.widget.AppCompatTextView phone = null;
        private final android.widget.ImageView isDefault = null;
        private final androidx.appcompat.widget.AppCompatTextView edit = null;
        private final androidx.appcompat.widget.AppCompatTextView delete = null;
        @org.jetbrains.annotations.Nullable
        private com.tatayab.model.requests.AddressRequest address;
        
        public AddressViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tatayab.model.requests.AddressRequest getAddress() {
            return null;
        }
        
        public final void setAddress(@org.jetbrains.annotations.Nullable
        com.tatayab.model.requests.AddressRequest p0) {
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.requests.AddressRequest address) {
        }
    }
}