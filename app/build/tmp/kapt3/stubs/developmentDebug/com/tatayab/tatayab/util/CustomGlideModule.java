package com.tatayab.tatayab.util;

import java.lang.System;

/**
 * Customize Glide module:
 *
 * Especially enable TLS12 on pre-lollipop devices.
 * https://github.com/square/okhttp/issues/2372
 * https://bumptech.github.io/glide/doc/getting-started.html#applications
 */
@com.bumptech.glide.annotation.GlideModule
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tatayab/tatayab/util/CustomGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "registerComponents", "", "context", "Landroid/content/Context;", "glide", "Lcom/bumptech/glide/Glide;", "registry", "Lcom/bumptech/glide/Registry;", "app_developmentDebug"})
public final class CustomGlideModule extends com.bumptech.glide.module.AppGlideModule {
    
    public CustomGlideModule() {
        super();
    }
    
    @java.lang.Override
    public void registerComponents(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.bumptech.glide.Glide glide, @org.jetbrains.annotations.NotNull
    com.bumptech.glide.Registry registry) {
    }
}