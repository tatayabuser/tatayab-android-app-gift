package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a(\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\f\u001a\u0014\u0010\u0015\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\nH\u0002\u001a0\u0010\u0017\u001a\u00020\u0001*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c\u001a2\u0010\u0017\u001a\u00020\u0001*\u00020\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\"\u0010\u001e\u001a\u00020\u0001*\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\"\u0010\u001e\u001a\u00020\u0001*\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"*\u00020\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c\u00a8\u0006#"}, d2 = {"attachNavHostFragment", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "isPrimaryNavFragment", "", "detachNavHostFragment", "getFragmentTag", "", "index", "", "obtainNavHostFragment", "fragmentTag", "navGraphId", "containerId", "getFragmentNavController", "Landroidx/navigation/NavController;", "Landroidx/fragment/app/Fragment;", "id", "isOnBackStack", "backStackName", "setupDeepLinks", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "navGraphIds", "", "intent", "Landroid/content/Intent;", "Lcom/google/android/material/navigation/NavigationView;", "setupItemReselected", "graphIdToTagMap", "Landroid/util/SparseArray;", "setupWithNavController", "Landroidx/lifecycle/LiveData;", "app_developmentDebug"})
public final class NavigationExtensionsKt {
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.lifecycle.LiveData<androidx.navigation.NavController> setupWithNavController(@org.jetbrains.annotations.NotNull
    com.google.android.material.bottomnavigation.BottomNavigationView $this$setupWithNavController, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> navGraphIds, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, int containerId, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.lifecycle.LiveData<androidx.navigation.NavController> setupWithNavController(@org.jetbrains.annotations.NotNull
    com.google.android.material.navigation.NavigationView $this$setupWithNavController, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> navGraphIds, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, int containerId, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    public static final void setupDeepLinks(@org.jetbrains.annotations.NotNull
    com.google.android.material.bottomnavigation.BottomNavigationView $this$setupDeepLinks, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> navGraphIds, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager fragmentManager, int containerId, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    private static final void setupDeepLinks(com.google.android.material.navigation.NavigationView $this$setupDeepLinks, java.util.List<java.lang.Integer> navGraphIds, androidx.fragment.app.FragmentManager fragmentManager, int containerId, android.content.Intent intent) {
    }
    
    private static final void setupItemReselected(com.google.android.material.bottomnavigation.BottomNavigationView $this$setupItemReselected, android.util.SparseArray<java.lang.String> graphIdToTagMap, androidx.fragment.app.FragmentManager fragmentManager) {
    }
    
    private static final void setupItemReselected(com.google.android.material.navigation.NavigationView $this$setupItemReselected, android.util.SparseArray<java.lang.String> graphIdToTagMap, androidx.fragment.app.FragmentManager fragmentManager) {
    }
    
    private static final void detachNavHostFragment(androidx.fragment.app.FragmentManager fragmentManager, androidx.navigation.fragment.NavHostFragment navHostFragment) {
    }
    
    private static final void attachNavHostFragment(androidx.fragment.app.FragmentManager fragmentManager, androidx.navigation.fragment.NavHostFragment navHostFragment, boolean isPrimaryNavFragment) {
    }
    
    private static final androidx.navigation.fragment.NavHostFragment obtainNavHostFragment(androidx.fragment.app.FragmentManager fragmentManager, java.lang.String fragmentTag, int navGraphId, int containerId) {
        return null;
    }
    
    private static final boolean isOnBackStack(androidx.fragment.app.FragmentManager $this$isOnBackStack, java.lang.String backStackName) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final androidx.navigation.NavController getFragmentNavController(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$getFragmentNavController, @androidx.annotation.IdRes
    int id) {
        return null;
    }
    
    private static final java.lang.String getFragmentTag(int index) {
        return null;
    }
}