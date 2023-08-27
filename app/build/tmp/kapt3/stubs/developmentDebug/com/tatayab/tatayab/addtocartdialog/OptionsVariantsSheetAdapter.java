package com.tatayab.tatayab.addtocartdialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tatayab/tatayab/addtocartdialog/OptionsVariantsSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/addtocartdialog/OptionsVariantsSheetAdapter$OptionViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnOptionSelectedFromSheet;", "items", "", "Lcom/tatayab/model/responses/OptionVariant;", "optionId", "", "optionPosition", "(Lcom/tatayab/tatayab/listener/OnOptionSelectedFromSheet;Ljava/util/List;II)V", "mSelectedItem", "getMSelectedItem", "()I", "setMSelectedItem", "(I)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OptionViewHolder", "app_developmentDebug"})
public final class OptionsVariantsSheetAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.addtocartdialog.OptionsVariantsSheetAdapter.OptionViewHolder> {
    private final com.tatayab.tatayab.listener.OnOptionSelectedFromSheet listener = null;
    private final java.util.List<com.tatayab.model.responses.OptionVariant> items = null;
    private final int optionId = 0;
    private final int optionPosition = 0;
    private int mSelectedItem = -1;
    
    public OptionsVariantsSheetAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnOptionSelectedFromSheet listener, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.responses.OptionVariant> items, int optionId, int optionPosition) {
        super();
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final int getMSelectedItem() {
        return 0;
    }
    
    public final void setMSelectedItem(int p0) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.addtocartdialog.OptionsVariantsSheetAdapter.OptionViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.addtocartdialog.OptionsVariantsSheetAdapter.OptionViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tatayab/tatayab/addtocartdialog/OptionsVariantsSheetAdapter$OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/addtocartdialog/OptionsVariantsSheetAdapter;Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "variant", "Lcom/tatayab/model/responses/OptionVariant;", "getVariant", "()Lcom/tatayab/model/responses/OptionVariant;", "setVariant", "(Lcom/tatayab/model/responses/OptionVariant;)V", "bindTo", "", "variant1", "position", "", "app_developmentDebug"})
    public final class OptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull
        private final android.content.Context context = null;
        @org.jetbrains.annotations.Nullable
        private com.tatayab.model.responses.OptionVariant variant;
        
        public OptionViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tatayab.model.responses.OptionVariant getVariant() {
            return null;
        }
        
        public final void setVariant(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.OptionVariant p0) {
        }
        
        public final void bindTo(@org.jetbrains.annotations.Nullable
        com.tatayab.model.responses.OptionVariant variant1, int position) {
        }
    }
}