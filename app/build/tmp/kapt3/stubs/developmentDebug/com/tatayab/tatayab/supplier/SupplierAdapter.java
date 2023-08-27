package com.tatayab.tatayab.supplier;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u00010B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0086\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0016\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0017J\u001c\u0010\'\u001a\u00020(2\n\u0010)\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020\u0012H\u0016J\u001c\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0012H\u0016J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tatayab/tatayab/supplier/SupplierAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/supplier/SupplierAdapter$BrandViewHolder;", "Landroid/widget/SectionIndexer;", "listener", "Lcom/tatayab/tatayab/listener/OnSupplierListener;", "mSuppliersList", "", "Lcom/tatayab/model/responses/SupplierResponse;", "mContext", "Landroid/content/Context;", "(Lcom/tatayab/tatayab/listener/OnSupplierListener;Ljava/util/List;Landroid/content/Context;)V", "getListener", "()Lcom/tatayab/tatayab/listener/OnSupplierListener;", "getMContext", "()Landroid/content/Context;", "mSectionPositions", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMSuppliersList", "()Ljava/util/List;", "sections", "", "compareTo", "o", "", "getItemCount", "getPositionForSection", "i", "getSectionForPosition", "getSections", "", "()[Ljava/lang/String;", "isArabicChar", "", "chr", "isLetters", "char", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "positionIsExitsInSectionsList", "BrandViewHolder", "app_developmentDebug"})
public final class SupplierAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.supplier.SupplierAdapter.BrandViewHolder> implements android.widget.SectionIndexer {
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.tatayab.listener.OnSupplierListener listener = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.tatayab.model.responses.SupplierResponse> mSuppliersList = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context mContext = null;
    private java.util.ArrayList<java.lang.Integer> mSectionPositions;
    private java.util.ArrayList<java.lang.String> sections;
    
    public SupplierAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnSupplierListener listener, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.SupplierResponse> mSuppliersList, @org.jetbrains.annotations.NotNull
    android.content.Context mContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.listener.OnSupplierListener getListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.tatayab.model.responses.SupplierResponse> getMSuppliersList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.supplier.SupplierAdapter.BrandViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.supplier.SupplierAdapter.BrandViewHolder holder, int position) {
    }
    
    public final int positionIsExitsInSectionsList(int position) {
        return 0;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String[] getSections() {
        return null;
    }
    
    public final boolean isLetters(@org.jetbrains.annotations.NotNull
    java.lang.String p0_1526187) {
        return false;
    }
    
    private final boolean isArabicChar(java.lang.String chr) {
        return false;
    }
    
    @java.lang.Override
    public int getPositionForSection(int i) {
        return 0;
    }
    
    @java.lang.Override
    public int getSectionForPosition(int i) {
        return 0;
    }
    
    public final int compareTo(@org.jetbrains.annotations.NotNull
    java.lang.Object o) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tatayab/tatayab/supplier/SupplierAdapter$BrandViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tatayab/tatayab/supplier/SupplierAdapter;Landroid/view/View;)V", "brandProfileIcon", "Landroid/widget/ImageView;", "getBrandProfileIcon", "()Landroid/widget/ImageView;", "setBrandProfileIcon", "(Landroid/widget/ImageView;)V", "header", "Landroid/widget/TextView;", "getHeader", "()Landroid/widget/TextView;", "setHeader", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "app_developmentDebug"})
    public final class BrandViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView title;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView header;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView brandProfileIcon;
        
        public BrandViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getHeader() {
            return null;
        }
        
        public final void setHeader(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getBrandProfileIcon() {
            return null;
        }
        
        public final void setBrandProfileIcon(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
    }
}