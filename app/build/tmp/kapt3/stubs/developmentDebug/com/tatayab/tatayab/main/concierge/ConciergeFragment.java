package com.tatayab.tatayab.main.concierge;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\"\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J-\u0010+\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0016\u00a2\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\b\u00106\u001a\u00020\u0019H\u0002J\u0006\u00107\u001a\u00020\u0019J\b\u00108\u001a\u00020\u0019H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/tatayab/tatayab/main/concierge/ConciergeFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "()V", "CAMERA", "", "GALLERY", "MY_CAMERA_PERMISSION_CODE", "READ_STORAGE_REQUEST", "conciergeRequestBody", "Lcom/tatayab/model/requests/ConciergeRequestBody;", "getConciergeRequestBody", "()Lcom/tatayab/model/requests/ConciergeRequestBody;", "mConciergeViewModelFactory", "Lcom/tatayab/presentation/addconcierge/ConciergeViewModelFactory$Factory;", "getMConciergeViewModelFactory", "()Lcom/tatayab/presentation/addconcierge/ConciergeViewModelFactory$Factory;", "setMConciergeViewModelFactory", "(Lcom/tatayab/presentation/addconcierge/ConciergeViewModelFactory$Factory;)V", "viewModel", "Lcom/tatayab/presentation/addconcierge/ConciergeViewModel;", "getViewModel", "()Lcom/tatayab/presentation/addconcierge/ConciergeViewModel;", "setViewModel", "(Lcom/tatayab/presentation/addconcierge/ConciergeViewModel;)V", "choosePhotoFromGallary", "", "initView", "layoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "openCamera", "resetForm", "showPictureDialog", "showSuccessAlert", "takePhotoFromCamera", "validatePhoneNumber", "", "phone", "app_developmentDebug"})
public final class ConciergeFragment extends com.tatayab.tatayab.base.BaseFragment2 {
    public com.tatayab.presentation.addconcierge.ConciergeViewModel viewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.addconcierge.ConciergeViewModelFactory.Factory mConciergeViewModelFactory;
    private final int GALLERY = 1;
    private final int CAMERA = 2;
    private final int READ_STORAGE_REQUEST = 111;
    private final int MY_CAMERA_PERMISSION_CODE = 2124;
    @org.jetbrains.annotations.NotNull
    private final com.tatayab.model.requests.ConciergeRequestBody conciergeRequestBody = null;
    private java.util.HashMap _$_findViewCache;
    
    public ConciergeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.addconcierge.ConciergeViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.addconcierge.ConciergeViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.addconcierge.ConciergeViewModelFactory.Factory getMConciergeViewModelFactory() {
        return null;
    }
    
    public final void setMConciergeViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.addconcierge.ConciergeViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.model.requests.ConciergeRequestBody getConciergeRequestBody() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void resetForm() {
    }
    
    private final void showPictureDialog() {
    }
    
    public final void choosePhotoFromGallary() {
    }
    
    private final void takePhotoFromCamera() {
    }
    
    private final void openCamera() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean validatePhoneNumber(java.lang.String phone) {
        return false;
    }
    
    private final void initView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    public final void showSuccessAlert() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
}