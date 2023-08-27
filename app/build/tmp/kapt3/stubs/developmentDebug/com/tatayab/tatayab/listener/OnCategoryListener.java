package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tatayab/tatayab/listener/OnCategoryListener;", "", "onBannerSeeMoreSelected", "", "categoryId", "", "bannerList", "Ljava/util/ArrayList;", "Lcom/tatayab/model/responses/Child;", "Lkotlin/collections/ArrayList;", "bannerTitle", "bannerType", "", "onBannerSelected", "url", "onCategorySelected", "categoryName", "onSubCategorySelected", "app_developmentDebug"})
public abstract interface OnCategoryListener {
    
    public abstract void onCategorySelected(@org.jetbrains.annotations.NotNull
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull
    java.lang.String categoryName);
    
    public abstract void onSubCategorySelected(@org.jetbrains.annotations.Nullable
    java.lang.String categoryId, @org.jetbrains.annotations.Nullable
    java.lang.String categoryName);
    
    public abstract void onBannerSelected(@org.jetbrains.annotations.Nullable
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull
    java.lang.String url);
    
    public abstract void onBannerSeeMoreSelected(@org.jetbrains.annotations.NotNull
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.tatayab.model.responses.Child> bannerList, @org.jetbrains.annotations.NotNull
    java.lang.String bannerTitle, int bannerType);
}