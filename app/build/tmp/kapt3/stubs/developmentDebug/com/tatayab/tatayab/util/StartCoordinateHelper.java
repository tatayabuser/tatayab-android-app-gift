package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tatayab/tatayab/util/StartCoordinateHelper;", "Lcom/tatayab/tatayab/util/CoordinateHelper;", "()V", "getBaseCoordinate", "", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "getTargetCoordinate", "targetView", "Landroid/view/View;", "app_developmentDebug"})
public final class StartCoordinateHelper implements com.tatayab.tatayab.util.CoordinateHelper {
    
    public StartCoordinateHelper() {
        super();
    }
    
    /**
     * Gets the coordinate of the start of RecyclerView.
     */
    @java.lang.Override
    public int getBaseCoordinate(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.OrientationHelper helper) {
        return 0;
    }
    
    /**
     * Gets the coordinate from the start of [targetView].
     */
    @java.lang.Override
    public int getTargetCoordinate(@org.jetbrains.annotations.NotNull
    android.view.View targetView, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.OrientationHelper helper) {
        return 0;
    }
}