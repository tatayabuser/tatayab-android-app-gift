package com.tatayab.tatayab.refer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006&"}, d2 = {"Lcom/tatayab/tatayab/refer/ReferFriendFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "()V", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "totalCreditText", "getTotalCreditText", "setTotalCreditText", "viewModel", "Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModel;", "viewModelFactory", "Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/referFriend/ReferFriendSuccessViewModelFactory$Factory;)V", "intComponent", "", "invitFriend", "userId", "userName", "layoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "shareApp", "shortLink", "updateUI", "it", "Lcom/tatayab/model/responses/InviteFriendResponse;", "app_developmentDebug"})
public final class ReferFriendFragment extends com.tatayab.tatayab.base.BaseFragment2 {
    private com.tatayab.presentation.referFriend.ReferFriendSuccessViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory.Factory viewModelFactory;
    @org.jetbrains.annotations.NotNull
    private java.lang.String totalCreditText = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.String currency;
    private java.util.HashMap _$_findViewCache;
    
    public ReferFriendFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTotalCreditText() {
        return null;
    }
    
    public final void setTotalCreditText(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateUI(com.tatayab.model.responses.InviteFriendResponse it) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void intComponent() {
    }
    
    public final void invitFriend(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String userName) {
    }
    
    private final void shareApp(java.lang.String shortLink, java.lang.String userName) {
    }
}