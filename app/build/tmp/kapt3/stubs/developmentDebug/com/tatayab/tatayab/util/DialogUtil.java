package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tatayab/tatayab/util/DialogUtil;", "", "()V", "checkTheMessage", "", "context", "Landroid/content/Context;", "message", "getDialogStyle", "", "mMessageType", "Lcom/tatayab/tatayab/util/DialogUtil$MessageType;", "getIcon", "hideDialogWithDelay", "", "dialog", "Landroid/app/Dialog;", "setLayoutParamDialog", "gravity", "isToolbar", "", "showCustomDialog", "mesg", "showCustomSuccessDialog", "showDialog", "MessageType", "app_developmentDebug"})
public class DialogUtil {
    
    public DialogUtil() {
        super();
    }
    
    public final void showDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String mesg) {
    }
    
    public final void showCustomDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isToolbar, @org.jetbrains.annotations.Nullable
    java.lang.String mesg, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    public final void showCustomSuccessDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isToolbar, @org.jetbrains.annotations.Nullable
    java.lang.String mesg, @org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
    }
    
    private final java.lang.String checkTheMessage(android.content.Context context, java.lang.String message) {
        return null;
    }
    
    private final int getIcon(com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
        return 0;
    }
    
    private final int getDialogStyle(com.tatayab.tatayab.util.DialogUtil.MessageType mMessageType) {
        return 0;
    }
    
    /**
     * Set layout parameter.
     *
     * @param dialog    dialog "
     * @param gravity   int top or bottom
     * @param context
     * @param isToolbar
     */
    private final void setLayoutParamDialog(android.app.Dialog dialog, int gravity, android.content.Context context, boolean isToolbar) {
    }
    
    /**
     * Hide dialog  with a delay.
     *
     * @param dialog dialog "no internet"
     */
    private final void hideDialogWithDelay(android.app.Dialog dialog) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tatayab/tatayab/util/DialogUtil$MessageType;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "INFO", "WARRING", "app_developmentDebug"})
    public static enum MessageType {
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ INFO /* = new INFO() */,
        /*public static final*/ WARRING /* = new WARRING() */;
        
        MessageType() {
        }
    }
}