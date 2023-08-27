package com.tatayab.tatayab.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&JB\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tatayab/tatayab/listener/CheckoutLoginListener;", "", "continueAsGuest", "", "loginWithEmail", "loginWithSocial", "email", "", "phone", "firstname", "reg_type", "social_id", "langCode", "app_developmentDebug"})
public abstract interface CheckoutLoginListener {
    
    public abstract void loginWithSocial(@org.jetbrains.annotations.Nullable
    java.lang.String email, @org.jetbrains.annotations.Nullable
    java.lang.String phone, @org.jetbrains.annotations.Nullable
    java.lang.String firstname, @org.jetbrains.annotations.Nullable
    java.lang.String reg_type, @org.jetbrains.annotations.Nullable
    java.lang.String social_id, @org.jetbrains.annotations.NotNull
    java.lang.String langCode);
    
    public abstract void loginWithEmail();
    
    public abstract void continueAsGuest();
}