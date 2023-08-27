package com.tatayab.tatayab.main.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tatayab/tatayab/main/account/AccountSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/main/account/AccountSettingAdapter$ViewHolder;", "items", "", "Lcom/tatayab/model/account/AccountItem;", "listener", "Lcom/tatayab/tatayab/listener/OnAccountItemClick;", "(Ljava/util/List;Lcom/tatayab/tatayab/listener/OnAccountItemClick;)V", "getItems", "()Ljava/util/List;", "getListener", "()Lcom/tatayab/tatayab/listener/OnAccountItemClick;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_developmentDebug"})
public final class AccountSettingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.main.account.AccountSettingAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.tatayab.model.account.AccountItem> items = null;
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.tatayab.listener.OnAccountItemClick listener = null;
    
    public AccountSettingAdapter(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.account.AccountItem> items, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnAccountItemClick listener) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.account.AccountItem> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.listener.OnAccountItemClick getListener() {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.main.account.AccountSettingAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.main.account.AccountSettingAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tatayab/tatayab/main/account/AccountSettingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tatayab/tatayab/main/account/AccountSettingAdapter;Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "items", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getItems", "()Landroidx/recyclerview/widget/RecyclerView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "bind", "", "item", "Lcom/tatayab/model/account/AccountItem;", "listener", "Lcom/tatayab/tatayab/listener/OnAccountItemClick;", "app_developmentDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final androidx.recyclerview.widget.RecyclerView items = null;
        private final android.widget.TextView title = null;
        @org.jetbrains.annotations.NotNull
        private final android.content.Context context = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final androidx.recyclerview.widget.RecyclerView getItems() {
            return null;
        }
        
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getContext() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable
        com.tatayab.model.account.AccountItem item, @org.jetbrains.annotations.NotNull
        com.tatayab.tatayab.listener.OnAccountItemClick listener) {
        }
    }
}