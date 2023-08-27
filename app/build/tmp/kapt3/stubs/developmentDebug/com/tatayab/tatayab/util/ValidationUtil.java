package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tatayab/tatayab/util/ValidationUtil;", "", "()V", "emptyValidation", "", "context", "Landroid/content/Context;", "editText", "Lcom/google/android/material/textfield/TextInputEditText;", "message", "", "isValid", "input", "", "isValidEmail", "email", "app_developmentDebug"})
public final class ValidationUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.tatayab.tatayab.util.ValidationUtil INSTANCE = null;
    
    private ValidationUtil() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isValid(@org.jetbrains.annotations.NotNull
    java.lang.String input) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isValid(@org.jetbrains.annotations.NotNull
    com.google.android.material.textfield.TextInputEditText input) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean emptyValidation(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.google.android.material.textfield.TextInputEditText editText, int message) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isValidEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.google.android.material.textfield.TextInputEditText editText, int message) {
        return false;
    }
}