package com.tatayab.tatayab.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\b\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/tatayab/tatayab/firebase/InAppMessageListener;", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingClickListener;", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingImpressionListener;", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplayErrorListener;", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplay;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contxt", "getContxt", "()Landroid/content/Context;", "setContxt", "displayErrorEncountered", "", "inAppMessage", "Lcom/google/firebase/inappmessaging/model/InAppMessage;", "inAppMessagingErrorReason", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason;", "displayMessage", "p1", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessagingDisplayCallbacks;", "handelButtonAction", "url", "", "impressionDetected", "messageClicked", "action", "Lcom/google/firebase/inappmessaging/model/Action;", "app_developmentDebug"})
public final class InAppMessageListener implements com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener, com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener, com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener, com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay {
    public android.content.Context contxt;
    
    public InAppMessageListener(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override
    public void displayMessage(@org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.model.InAppMessage inAppMessage, @org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks p1) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContxt() {
        return null;
    }
    
    public final void setContxt(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @java.lang.Override
    public void messageClicked(@org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.model.InAppMessage inAppMessage, @org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.model.Action action) {
    }
    
    private final void handelButtonAction(java.lang.String url) {
    }
    
    @java.lang.Override
    public void impressionDetected(@org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.model.InAppMessage inAppMessage) {
    }
    
    @java.lang.Override
    public void displayErrorEncountered(@org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.model.InAppMessage inAppMessage, @org.jetbrains.annotations.NotNull
    com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
    }
}