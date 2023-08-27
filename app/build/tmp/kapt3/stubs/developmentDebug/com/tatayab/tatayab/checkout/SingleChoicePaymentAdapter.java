package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tatayab/tatayab/checkout/SingleChoicePaymentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tatayab/tatayab/checkout/SingleChoicePaymentAdapter$SingleViewHolder;", "listener", "Lcom/tatayab/tatayab/listener/OnPaymentListener;", "decimalNumbers", "", "(Lcom/tatayab/tatayab/listener/OnPaymentListener;I)V", "checkedPosition", "coefficient", "", "Ljava/lang/Float;", "countryCode", "", "paymentMethods", "", "Lcom/tatayab/model/PaymentMethod;", "selected", "getSelected", "()Lcom/tatayab/model/PaymentMethod;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPaymentMethods", "SingleViewHolder", "app_developmentDebug"})
public final class SingleChoicePaymentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tatayab.tatayab.checkout.SingleChoicePaymentAdapter.SingleViewHolder> {
    private final com.tatayab.tatayab.listener.OnPaymentListener listener = null;
    private final int decimalNumbers = 0;
    private int checkedPosition = 0;
    private java.lang.Float coefficient;
    private java.util.List<com.tatayab.model.PaymentMethod> paymentMethods;
    private java.lang.String countryCode;
    
    public SingleChoicePaymentAdapter(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.listener.OnPaymentListener listener, int decimalNumbers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.tatayab.tatayab.checkout.SingleChoicePaymentAdapter.SingleViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.checkout.SingleChoicePaymentAdapter.SingleViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void setPaymentMethods(float coefficient, @org.jetbrains.annotations.NotNull
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull
    java.util.List<com.tatayab.model.PaymentMethod> paymentMethods) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.model.PaymentMethod getSelected() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tatayab/tatayab/checkout/SingleChoicePaymentAdapter$SingleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/tatayab/tatayab/checkout/SingleChoicePaymentAdapter;Landroid/view/View;)V", "coefficient", "", "Ljava/lang/Float;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "countryCode", "", "paymentMethod", "Lcom/tatayab/model/PaymentMethod;", "bind", "", "position", "", "onClick", "v", "setChecked", "value", "", "setPaymentIcon", "setRadioImg", "app_developmentDebug"})
    public final class SingleViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        private com.tatayab.model.PaymentMethod paymentMethod;
        private java.lang.String countryCode;
        private java.lang.Float coefficient;
        private final android.content.Context context = null;
        
        public SingleViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.tatayab.model.PaymentMethod paymentMethod, @org.jetbrains.annotations.NotNull
        java.lang.String countryCode, float coefficient, int position) {
        }
        
        private final void setChecked(boolean value) {
        }
        
        @java.lang.Override
        public void onClick(@org.jetbrains.annotations.Nullable
        android.view.View v) {
        }
        
        private final void setPaymentIcon() {
        }
        
        private final void setRadioImg(int position) {
        }
    }
}