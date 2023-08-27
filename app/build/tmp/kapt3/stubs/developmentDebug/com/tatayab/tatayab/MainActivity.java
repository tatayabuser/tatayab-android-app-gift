package com.tatayab.tatayab;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0080\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0006\u0010.\u001a\u00020+J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\bH\u0002J\u001a\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u00010\b2\b\u00105\u001a\u0004\u0018\u00010\bJ\u0010\u00106\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\bH\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u00100\u001a\u00020=H\u0002J\u0006\u0010>\u001a\u00020+J\u0006\u0010?\u001a\u00020+J\b\u0010@\u001a\u00020+H\u0002J\u0010\u0010A\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010B\u001a\u00020+H\u0002J\b\u0010C\u001a\u00020+H\u0002J\u000e\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020\bJ\u0006\u0010F\u001a\u00020+J\u0006\u0010G\u001a\u00020+J\u000e\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u000208J\u0006\u0010J\u001a\u00020+J\b\u0010K\u001a\u00020+H\u0016J\b\u0010L\u001a\u00020+H\u0016J\u0006\u0010M\u001a\u00020+J\"\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010-H\u0014J\b\u0010S\u001a\u00020+H\u0016J\u0012\u0010T\u001a\u00020+2\b\u0010U\u001a\u0004\u0018\u000108H\u0014J\u0012\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010[\u001a\u00020+2\u0006\u0010U\u001a\u000208H\u0014J\b\u0010\\\u001a\u00020+H\u0014J\b\u0010]\u001a\u00020WH\u0016J\u0010\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020WH\u0002J\u0012\u0010`\u001a\u00020+2\b\u0010a\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010b\u001a\u00020+H\u0002J\u0010\u0010c\u001a\u00020+2\u0006\u0010d\u001a\u00020\bH\u0002J \u0010e\u001a\u00020+2\u0006\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0006\u0010h\u001a\u00020+J\u0006\u0010i\u001a\u00020+J\b\u0010j\u001a\u00020+H\u0002J\b\u0010k\u001a\u00020+H\u0002J\u0006\u0010l\u001a\u00020+J\u0010\u0010m\u001a\u00020+2\u0006\u0010n\u001a\u00020\rH\u0002J\b\u0010o\u001a\u00020+H\u0002J\b\u0010p\u001a\u00020+H\u0002J\u001a\u0010q\u001a\u00020+2\b\u0010d\u001a\u0004\u0018\u00010\b2\b\u0010r\u001a\u0004\u0018\u00010\bJ\u0006\u0010s\u001a\u00020+J\u0006\u0010t\u001a\u00020+J\u0010\u0010u\u001a\u00020+2\u0006\u0010v\u001a\u00020PH\u0002J\u000e\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020yJ\u0006\u0010z\u001a\u00020+J\b\u0010{\u001a\u00020+H\u0002J\b\u0010|\u001a\u00020+H\u0004J\u000e\u0010}\u001a\u00020+2\u0006\u0010v\u001a\u00020PJ\u0010\u0010~\u001a\u00020+2\u0006\u0010\u007f\u001a\u00020WH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tatayab/tatayab/MainActivity;", "Lcom/tatayab/tatayab/base/BaseActivity2;", "Lcom/tatayab/tatayab/listener/OnHomeNavigationListener;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "Lcom/tatayab/tatayab/listener/OnCategoryNavigationListener;", "Lcom/tatayab/tatayab/util/FirebaseConfigListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "categoryName", "currentNavController", "Landroidx/lifecycle/LiveData;", "Landroidx/navigation/NavController;", "itemCount", "Landroid/view/View;", "mFirebaseConfigUtil", "Lcom/tatayab/tatayab/util/FirebaseConfigUtil;", "getMFirebaseConfigUtil", "()Lcom/tatayab/tatayab/util/FirebaseConfigUtil;", "setMFirebaseConfigUtil", "(Lcom/tatayab/tatayab/util/FirebaseConfigUtil;)V", "mSharedPrefManager", "Lcom/tatayab/tatayab/util/deskCache/SharedPrefManager;", "getMSharedPrefManager", "()Lcom/tatayab/tatayab/util/deskCache/SharedPrefManager;", "setMSharedPrefManager", "(Lcom/tatayab/tatayab/util/deskCache/SharedPrefManager;)V", "viewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "viewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "wishlistViewModel", "Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;", "getWishlistViewModel", "()Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;", "setWishlistViewModel", "(Lcom/tatayab/presentation/wishlist/WishlistFragmentViewModel;)V", "checkIntent", "", "intent", "Landroid/content/Intent;", "clearCart", "getCategoryName", "deepLink", "handelCustomDeeplink", "uri", "handelExtractUrl", "type", "id", "handelIntent", "bundle", "Landroid/os/Bundle;", "handelLocalNavigation", "handleDeeplinkLocal", "url", "handleShareCartDeeplink", "Landroid/net/Uri;", "hideBottomBar", "hideBottomNavigation", "initAction", "initDynamicLink", "initFacebookAnalytics", "initInsiderCallBacks", "isExpiredMessage", "message", "loginSucceed", "logout", "navigateBackWithResult", "result", "navigatedToCartFragment", "navigatedToCategoryFragment", "navigatedToHomeFragment", "navigatedToProfileFragment", "onActivityResult", "requestCode", "", "resultCode", "data", "onBackPressed", "onCreate", "savedInstanceState", "onQueryTextChange", "", "newText", "onQueryTextSubmit", "query", "onRestoreInstanceState", "onResume", "onSupportNavigateUp", "openLogin", "login", "openMyOrder", "orderID", "openMyWallet", "openProductDetails", "productId", "openProductList", "categoryType", "categoryId", "printHashKey", "redirectToPlayStore", "removeCartCount", "removeCurrentUserFromCache", "resetLoadAllHomeBlocksAgain", "setupBackNavIcon", "navController", "setupBottomNavigationBar", "setupCartIcon", "showAddProductReview", "productName", "showBottomBar", "showBottomNavigation", "showCartCount", "count", "showInAppMessage", "mInAppMessageModel", "Lcom/tatayab/model/responses/InAppMessageModel;", "showRateApp", "showRateAppFallbackDialog", "syncWithFirebaseCofig", "updateCartCount", "updateEnableGraphQlValue", "newGraphValue", "ActionType", "app_developmentDebug"})
public class MainActivity extends com.tatayab.tatayab.base.BaseActivity2 implements com.tatayab.tatayab.listener.OnHomeNavigationListener, androidx.appcompat.widget.SearchView.OnQueryTextListener, com.tatayab.tatayab.listener.OnCategoryNavigationListener, com.tatayab.tatayab.util.FirebaseConfigListener {
    private final java.lang.String TAG = null;
    private java.lang.String categoryName = "";
    private com.tatayab.presentation.main.MainActivityViewModel viewModel;
    @org.jetbrains.annotations.NotNull
    private com.tatayab.tatayab.util.FirebaseConfigUtil mFirebaseConfigUtil;
    @org.jetbrains.annotations.Nullable
    private com.tatayab.tatayab.util.deskCache.SharedPrefManager mSharedPrefManager;
    public com.tatayab.presentation.wishlist.WishlistFragmentViewModel wishlistViewModel;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory viewModelFactory;
    private androidx.lifecycle.LiveData<androidx.navigation.NavController> currentNavController;
    private android.view.View itemCount;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.tatayab.util.FirebaseConfigUtil getMFirebaseConfigUtil() {
        return null;
    }
    
    public final void setMFirebaseConfigUtil(@org.jetbrains.annotations.NotNull
    com.tatayab.tatayab.util.FirebaseConfigUtil p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.tatayab.util.deskCache.SharedPrefManager getMSharedPrefManager() {
        return null;
    }
    
    public final void setMSharedPrefManager(@org.jetbrains.annotations.Nullable
    com.tatayab.tatayab.util.deskCache.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.wishlist.WishlistFragmentViewModel getWishlistViewModel() {
        return null;
    }
    
    public final void setWishlistViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.wishlist.WishlistFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    protected final void syncWithFirebaseCofig() {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkIntent(android.content.Intent intent) {
    }
    
    private final void handelCustomDeeplink(java.lang.String uri) {
    }
    
    private final void initDynamicLink(android.content.Intent intent) {
    }
    
    private final void handleShareCartDeeplink(android.net.Uri deepLink) {
    }
    
    private final void initInsiderCallBacks() {
    }
    
    public final void printHashKey() {
    }
    
    private final void initAction() {
    }
    
    private final void setupBottomNavigationBar() {
    }
    
    private final void initFacebookAnalytics() {
    }
    
    @java.lang.Override
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupBackNavIcon(androidx.navigation.NavController navController) {
    }
    
    public final void loginSucceed() {
    }
    
    public final void clearCart() {
    }
    
    public final void logout() {
    }
    
    public final void updateCartCount(int count) {
    }
    
    private final void openLogin(boolean login) {
    }
    
    private final void showCartCount(int count) {
    }
    
    private final void removeCartCount() {
    }
    
    private final void setupCartIcon() {
    }
    
    /**
     * Called on first creation and when restoring state.
     */
    public final void handelIntent(@org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
    }
    
    private final void handleDeeplinkLocal(java.lang.String url) {
    }
    
    public final void handelLocalNavigation(@org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
    }
    
    private final void openMyWallet() {
    }
    
    private final void openMyOrder(java.lang.String orderID) {
    }
    
    private final void openProductDetails(java.lang.String productId) {
    }
    
    private final void openProductList(java.lang.String categoryType, java.lang.String categoryId, java.lang.String categoryName) {
    }
    
    public final void navigateBackWithResult(@org.jetbrains.annotations.NotNull
    android.os.Bundle result) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    public final void showAddProductReview(@org.jetbrains.annotations.Nullable
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    java.lang.String productName) {
    }
    
    @java.lang.Override
    public void navigatedToHomeFragment() {
    }
    
    public final void navigatedToCartFragment() {
    }
    
    public final void navigatedToProfileFragment() {
    }
    
    @java.lang.Override
    public void navigatedToCategoryFragment() {
    }
    
    @java.lang.Override
    public boolean onQueryTextSubmit(@org.jetbrains.annotations.Nullable
    java.lang.String query) {
        return false;
    }
    
    @java.lang.Override
    public boolean onQueryTextChange(@org.jetbrains.annotations.Nullable
    java.lang.String newText) {
        return false;
    }
    
    public final void hideBottomNavigation() {
    }
    
    public final void showBottomNavigation() {
    }
    
    public final void showInAppMessage(@org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.InAppMessageModel mInAppMessageModel) {
    }
    
    private final java.lang.String getCategoryName(java.lang.String deepLink) {
        return null;
    }
    
    public final void handelExtractUrl(@org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String id) {
    }
    
    public final void resetLoadAllHomeBlocksAgain() {
    }
    
    public final void showRateApp() {
    }
    
    /**
     * Showing native dialog with three buttons to review the app
     * Redirect user to PlayStore to review the app
     */
    private final void showRateAppFallbackDialog() {
    }
    
    public final void redirectToPlayStore() {
    }
    
    @java.lang.Override
    public void updateEnableGraphQlValue(boolean newGraphValue) {
    }
    
    private final void removeCurrentUserFromCache() {
    }
    
    public final void hideBottomBar() {
    }
    
    public final void showBottomBar() {
    }
    
    public final void isExpiredMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tatayab/tatayab/MainActivity$ActionType;", "", "(Ljava/lang/String;I)V", "register", "home", "app_developmentDebug"})
    public static enum ActionType {
        /*public static final*/ register /* = new register() */,
        /*public static final*/ home /* = new home() */;
        
        ActionType() {
        }
    }
}