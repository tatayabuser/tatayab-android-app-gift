package com.tatayab.tatayab.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tatayab/tatayab/profile/ChangePasswordFragment;", "Lcom/tatayab/tatayab/base/BaseFragment;", "()V", "newPassHidden", "", "passHidden", "viewModel", "Lcom/tatayab/presentation/profile/ProfileFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/profile/ProfileFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/profile/ProfileFragmentViewModel;)V", "layoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "validatePasswordInputs", "app_developmentDebug"})
public final class ChangePasswordFragment extends com.tatayab.tatayab.base.BaseFragment {
    @javax.inject.Inject
    public com.tatayab.presentation.profile.ProfileFragmentViewModel viewModel;
    private boolean passHidden = true;
    private boolean newPassHidden = true;
    private java.util.HashMap _$_findViewCache;
    
    public ChangePasswordFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.profile.ProfileFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.profile.ProfileFragmentViewModel p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean validatePasswordInputs() {
        return false;
    }
}