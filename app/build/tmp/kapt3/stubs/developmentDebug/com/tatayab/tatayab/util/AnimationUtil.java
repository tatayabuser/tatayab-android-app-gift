package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J2\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0003J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0007J \u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\nJ\u0018\u0010\'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\u001d\u00a8\u0006)"}, d2 = {"Lcom/tatayab/tatayab/util/AnimationUtil;", "", "()V", "animateAddToCart", "", "productImage", "Landroid/widget/ImageView;", "resources", "Landroid/content/res/Resources;", "itemCount", "Landroid/view/View;", "itemsRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "duration", "", "update", "Lkotlin/Function0;", "cartIconAnimatorSet", "Landroid/animation/AnimatorSet;", "getPositionOf", "", "view", "objectAnimatorOfFloat", "Landroid/animation/ObjectAnimator;", "propertyName", "", "startValue", "", "endValue", "rotate", "imageView", "rotateAnimationFile", "", "setupViewToAnimate", "imageSize", "showErrorDialogAnimation", "dialog", "springAnimateAddToCart", "delay", "app_developmentDebug"})
public final class AnimationUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.AnimationUtil INSTANCE = null;
    
    private AnimationUtil() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final android.animation.AnimatorSet cartIconAnimatorSet(@org.jetbrains.annotations.NotNull
    android.view.View itemCount) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    private static final android.animation.ObjectAnimator objectAnimatorOfFloat(android.view.View view, long duration, java.lang.String propertyName, float startValue, float endValue) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final int[] getPositionOf(@org.jetbrains.annotations.Nullable
    android.view.View view) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    private static final android.widget.ImageView setupViewToAnimate(android.widget.ImageView imageView, int imageSize, android.content.Context context) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void rotate(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView, int rotateAnimationFile) {
    }
    
    public final void springAnimateAddToCart(@org.jetbrains.annotations.NotNull
    android.view.View dialog, float delay) {
    }
    
    public final void showErrorDialogAnimation(@org.jetbrains.annotations.NotNull
    android.view.View dialog) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final void animateAddToCart(@org.jetbrains.annotations.NotNull
    android.widget.ImageView productImage, @org.jetbrains.annotations.NotNull
    android.content.res.Resources resources, @org.jetbrains.annotations.NotNull
    android.view.View itemCount, @org.jetbrains.annotations.NotNull
    androidx.constraintlayout.widget.ConstraintLayout itemsRootView, @org.jetbrains.annotations.NotNull
    android.content.Context context, long duration, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> update) {
    }
}