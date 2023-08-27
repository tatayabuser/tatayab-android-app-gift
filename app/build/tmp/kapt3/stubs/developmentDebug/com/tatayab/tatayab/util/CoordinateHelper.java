package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tatayab/tatayab/util/CoordinateHelper;", "", "getBaseCoordinate", "", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "getTargetCoordinate", "targetView", "Landroid/view/View;", "app_developmentDebug"})
public abstract interface CoordinateHelper {
    
    /**
     * find the coordinate of RceyclerView.
     */
    public abstract int getBaseCoordinate(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.OrientationHelper helper);
    
    /**
     * find the coordinate of [targetView] in RecyclerView.
     */
    public abstract int getTargetCoordinate(@org.jetbrains.annotations.NotNull
    android.view.View targetView, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.OrientationHelper helper);
}