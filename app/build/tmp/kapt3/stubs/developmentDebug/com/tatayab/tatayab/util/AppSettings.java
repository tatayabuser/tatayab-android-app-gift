package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tatayab/tatayab/util/AppSettings;", "", "currentLanguage", "Lcom/tatayab/tatayab/util/Language;", "getCurrentLanguage", "()Lcom/tatayab/tatayab/util/Language;", "setCurrentLanguage", "(Lcom/tatayab/tatayab/util/Language;)V", "firstUserToken", "", "getFirstUserToken", "()Ljava/lang/String;", "setFirstUserToken", "(Ljava/lang/String;)V", "app_developmentDebug"})
public abstract interface AppSettings {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.tatayab.tatayab.util.Language getCurrentLanguage();
    
    public abstract void setCurrentLanguage(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.Language p0);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getFirstUserToken();
    
    public abstract void setFirstUserToken(@org.jetbrains.annotations.NotNull
    java.lang.String p0);
}