package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tatayab/tatayab/util/MultiSnapHelper;", "Landroidx/recyclerview/widget/SnapHelper;", "interval", "", "index", "speedMsPerInch", "", "(IIF)V", "coordinateHelper", "Lcom/tatayab/tatayab/util/CoordinateHelper;", "orientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "createLayoutPositionHelper", "layoutManger", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "getCoordinateDelta", "getOrientationHelper", "Companion", "SnapGravity", "app_developmentDebug"})
public final class MultiSnapHelper extends androidx.recyclerview.widget.SnapHelper {
    private final int interval = 0;
    private int index;
    private final float speedMsPerInch = 0.0F;
    private com.tatayab.tatayab.util.CoordinateHelper coordinateHelper;
    private androidx.recyclerview.widget.OrientationHelper orientationHelper;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.MultiSnapHelper.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final com.tatayab.tatayab.util.MultiSnapHelper.SnapGravity DEFAULT_GRAVITY = com.tatayab.tatayab.util.MultiSnapHelper.SnapGravity.END;
    public static final int DEFAULT_INTERVAL = 2;
    public static final float DEFAULT_SPEED_MS_PER_INCH = 100.0F;
    
    public MultiSnapHelper() {
        super();
    }
    
    public MultiSnapHelper(int interval, int index, float speedMsPerInch) {
        super();
    }
    
    @java.lang.Override
    public void attachToRecyclerView(@org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    /**
     * Calculates the distance from [targetView].
     * This will be calculated based off of the specified [SnapGravity].
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public int[] calculateDistanceToFinalSnap(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, @org.jetbrains.annotations.NotNull
    android.view.View targetView) {
        return null;
    }
    
    /**
     * Finds and returns the views to snap.
     *
     * Iterates the all children views currently inflated and calculates the distance from base coordinate.
     * After checking all the children views, returns the child view that has the closest distance.
     * If all children views are invalid, just returns null.
     */
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View findSnapView(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return null;
    }
    
    /**
     * Finds and returns the next index to snap.
     *
     * For forward scrolling, this tries to find the index from the first index by incrementing.
     * Returns the index if the valid next index is found, otherwise returns the final index which means reaching the end edge.
     *
     * For backward scrolling, this tries to find the index from the last index by decrementing.
     * Returns the index if the valid next index is found, otherwise returns the final index which means reaching the start edge.
     */
    @java.lang.Override
    public int findTargetSnapPosition(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        return 0;
    }
    
    /**
     * Gets the delta between base coordinate and [targetView] coordinate.
     * If the returned value is positive, it means [targetView] is after the base coordinate,
     * otherwise [targetView] is before the base coordinate.
     */
    private final int getCoordinateDelta(android.view.View targetView, androidx.recyclerview.widget.OrientationHelper orientationHelper, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return 0;
    }
    
    /**
     * Gets [OrientationHelper] based on the layout orientation.
     * If [OrientationHelper] was created before, it returns the one previously created.
     */
    private final androidx.recyclerview.widget.OrientationHelper getOrientationHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        return null;
    }
    
    private final com.tatayab.tatayab.util.CoordinateHelper createLayoutPositionHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManger) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/util/MultiSnapHelper$SnapGravity;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CENTER", "START", "END", "Companion", "app_developmentDebug"})
    public static enum SnapGravity {
        /*public static final*/ CENTER /* = new CENTER(0) */,
        /*public static final*/ START /* = new START(0) */,
        /*public static final*/ END /* = new END(0) */;
        private final int value = 0;
        @org.jetbrains.annotations.NotNull
        public static final com.tatayab.tatayab.util.MultiSnapHelper.SnapGravity.Companion Companion = null;
        
        SnapGravity(int value) {
        }
        
        public final int getValue() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tatayab/tatayab/util/MultiSnapHelper$SnapGravity$Companion;", "", "()V", "valueOf", "Lcom/tatayab/tatayab/util/MultiSnapHelper$SnapGravity;", "value", "", "app_developmentDebug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.tatayab.tatayab.util.MultiSnapHelper.SnapGravity valueOf(int value) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/util/MultiSnapHelper$Companion;", "", "()V", "DEFAULT_GRAVITY", "Lcom/tatayab/tatayab/util/MultiSnapHelper$SnapGravity;", "getDEFAULT_GRAVITY", "()Lcom/tatayab/tatayab/util/MultiSnapHelper$SnapGravity;", "DEFAULT_INTERVAL", "", "DEFAULT_SPEED_MS_PER_INCH", "", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.tatayab.tatayab.util.MultiSnapHelper.SnapGravity getDEFAULT_GRAVITY() {
            return null;
        }
    }
}