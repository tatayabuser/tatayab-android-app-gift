package com.tatayab.tatayab.util;

import java.lang.System;

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J0\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/tatayab/tatayab/util/FragmentUtil;", "", "()V", "BACK_STACK_ROOT_TAG", "", "getBACK_STACK_ROOT_TAG$annotations", "addFirstFragmentToActivity", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "frameId", "", "activity", "Landroid/app/Activity;", "addFragmentToActivity", "addFragmentToFragment", "fragmentToHide", "fragmentToAdd", "id", "closeKeyboard", "replaceFragmentToActivity", "setFullScreen", "setRootView", "currentView", "tag", "setStatusBarColor", "color", "app_developmentDebug"})
public final class FragmentUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.FragmentUtil INSTANCE = null;
    private static final java.lang.String BACK_STACK_ROOT_TAG = "root_fragment";
    
    private FragmentUtil() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    @java.lang.Deprecated
    private static void getBACK_STACK_ROOT_TAG$annotations() {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void addFragmentToActivity(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment, int frameId, @org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void addFragmentToFragment(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragmentToHide, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragmentToAdd, int id) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void replaceFragmentToActivity(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment, int frameId, @org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void addFirstFragmentToActivity(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment, int frameId, @org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void setRootView(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment currentView, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, int frameId, @org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void closeKeyboard(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void setFullScreen(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void setStatusBarColor(int color, @org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
}