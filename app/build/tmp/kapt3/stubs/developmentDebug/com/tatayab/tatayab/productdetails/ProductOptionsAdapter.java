package com.tatayab.tatayab.productdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001+B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J(\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0007j\b\u0012\u0004\u0012\u00020\u001d`\tJ\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0016J6\u0010%\u001a\u00020\u001f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\'J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R:\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/tatayab/tatayab/productdetails/ProductOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/productdetails/ProductOptionsAdapter$ProductViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnOptionListener;", "(Lcom/tatayab/tatayab/listener/OnOptionListener;)V", "items", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/ProductOptions;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "selectedOptions", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSelectedOptions", "()Ljava/util/HashMap;", "setSelectedOptions", "(Ljava/util/HashMap;)V", "getItemCount", "", "getItemViewType", "position", "getVariantPosition", "variantId", "variants", "Lcom/tatayab/model/Variant;", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "options", "", "setVariantValue", "optionIndex", "variantIndex", "ProductViewHolder", "app_developmentDebug"})
public final class ProductOptionsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.productdetails.ProductOptionsAdapter.ProductViewHolder> {
    private final com.tatayab.tatayab.listener.OnOptionListener listener = null;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.responses.ProductOptions> items;
    @org.jetbrains.annotations.Nullable
    private java.util.HashMap<java.lang.String, java.lang.String> selectedOptions;
    
    public ProductOptionsAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnOptionListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.responses.ProductOptions> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.responses.ProductOptions> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.HashMap<java.lang.String, java.lang.String> getSelectedOptions() {
        return null;
    }
    
    public final void setSelectedOptions(@org.jetbrains.annotations.Nullable
    java.util.HashMap<java.lang.String, java.lang.String> p0) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.productdetails.ProductOptionsAdapter.ProductViewHolder holder, int position) {
    }
    
    public final void setVariantValue(int optionIndex, int variantIndex) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.productdetails.ProductOptionsAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.ProductOptions> items, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final int getVariantPosition(@org.jetbrains.annotations.Nullable
    java.lang.String variantId, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.Variant> variants) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0006*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0013\u001a\n \u0006*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n \u0006*\u0004\u0018\u00010\u00180\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tatayab/tatayab/productdetails/ProductOptionsAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/productdetails/ProductOptionsAdapter;Landroid/view/View;)V", "dark_view", "kotlin.jvm.PlatformType", "getDark_view", "()Landroid/view/View;", "option", "Landroid/widget/TextView;", "getOption", "()Landroid/widget/TextView;", "option_selected_img", "Landroid/widget/ImageView;", "getOption_selected_img", "()Landroid/widget/ImageView;", "option_selected_value", "getOption_selected_value", "option_title", "getOption_title", "options", "Lcom/tatayab/model/responses/ProductOptions;", "product_option", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProduct_option", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "bindTo", "", "listener", "Lcom/tatayab/tatayab/listener/OnOptionListener;", "app_developmentDebug"})
    public final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final android.widget.TextView option_title = null;
        private final androidx.constraintlayout.widget.ConstraintLayout product_option = null;
        private final android.widget.TextView option = null;
        private final android.widget.TextView option_selected_value = null;
        private final android.widget.ImageView option_selected_img = null;
        private final android.view.View dark_view = null;
        private com.tatayab.model.responses.ProductOptions options;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final android.widget.TextView getOption_title() {
            return null;
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getProduct_option() {
            return null;
        }
        
        public final android.widget.TextView getOption() {
            return null;
        }
        
        public final android.widget.TextView getOption_selected_value() {
            return null;
        }
        
        public final android.widget.ImageView getOption_selected_img() {
            return null;
        }
        
        public final android.view.View getDark_view() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.ProductOptions options, @org.jetbrains.annotations.NotNull
        com.tatayab.tatayab.listener.OnOptionListener listener) {
        }
    }
}