object Versions {
    // Android
    val androidMinSdkVersion = 26
    val androidTargetSdkVersion = 33
    val androidCompileSdkVersion = 32
    val androidBuildToolsVersion = "33.0.1"
    val appCompatVersion = "30.0.2"

    // Libraries
    val kotlinVersion = "1.6.10"
    val multidexVersion = "2.0.1"

    val axViewPager2Version = "1.0.0-alpha05"
    val axAnnotation = "1.0.1"
    val axAppcompat = "1.5.1"
    val axRecyclerView = "1.1.0-alpha01"
    val axCorektx = "1.1.0"
    val materialVersion = "1.3.0-alpha03"
    val axCardViewVersion = "1.0.0"
    val supportDesignVersion = "28.1.1"
    val lottieVersion = "3.0.6"
    val accountKitVersion = "5.0.0"
    val sdpVersion = "1.0.6"
    val facebookSdkVersion = "7.1.0"
    val securePrefVersion = "0.7.4"
    val avLoadingVersion = "2.1.3"
    val locationServiceVersion = "15.0.1"
    val newPlacesServiceVersion = "2.7.0"
    val rxLocationVersion = "2.1@aar"
    val swipeRevealVersion = "1.4.1"
    val circulerImageVersion = "3.0.0"

    val rxJavaVersion = "2.2.4"
    val rxAndroidVersion = "2.1.0"
    val rxKotlinVersion = "2.3.0"
    val javaxAnnotationVersion = "1.0"
    val javaxInjectionVersion = "1"

    val daggerVersion = "2.20"
    val gsonVersion = "2.8.5"
    val okhttpVersion = "3.12.0"
    val retrofitVersion = "2.4.0"

    val timberVersion = "4.7.1"
    val glideVersion = "4.14.2"
    val glassFishVersion = "10.0-b28"

    val roomVersion = "2.4.3"
    val lifecycleVersion = "2.1.0-alpha01"
    val espressoVersion = "3.1.1"
    val constraintLayoutVersion = "1.1.3"
    val paginLibVersion = "2.1.2"
    val assistedInjectVersion = "0.5.1"
    val playServiceAuthVersion = "19.0.0"
    val navVersion = "2.5.3"
    val fragmentXversion = "1.2.0-beta02"
    val fbLoginVersion = "[9.0)"
    val twitterSdkVersion = "3.1.1"
    val serializationConverterVersion = "0.4.0"
    val kotlinSerailizationVersion = "0.14.0"
    val stethoVersion = "1.5.1"
    val leakCanaryVersion="2.2"
    val searchDailogVersion="1.2.4"
    val firebaseAnalyticsVersion="17.2.2"
    val expandableRecycleViewVersion="1.4"
    val firebaseConfigVersion="19.1.1"
    val firebaseMessagingVersion ="20.2.0"
    val workManagerVersion="2.3.1"
    val firebaseInAppMessagingVersion="19.0.2"
    val firebaseCrashlyticsVersion="2.10.1"
    val firebaseCoreVersion="21.1.1"
    val firebaseIidVersion= "20.0.2"
    val firebaseDynamicLinksVersion="19.1.0"
    val callgraphVersion="2.3.0"
    val aviVersion="2.1.3"
    val smartLookVersion="1.7.0-native"
    val dynamicanimation_version="1.0.0"

}

object DomainDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    val pagingVersion = "androidx.paging:paging-runtime:${Versions.paginLibVersion}"
    val pagingRxVersion = "androidx.paging:paging-rxjava2:${Versions.paginLibVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

}

object DataDependencies {
    val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val pagingVersion = "androidx.paging:paging-runtime:${Versions.paginLibVersion}"
    val pagingRxVersion = "androidx.paging:paging-rxjava2:${Versions.paginLibVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

}

object RemoteDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val androidAnnotations = "androidx.annotation:annotation:${Versions.axAnnotation}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    val pagingVersion = "androidx.paging:paging-runtime:${Versions.paginLibVersion}"
    val pagingRxVersion = "androidx.paging:paging-rxjava2:${Versions.paginLibVersion}"

    val retrofitSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverterVersion}"
}


object CacheDependencies {
    val securePref = "online.devliving:securedpreferencestore:${Versions.securePrefVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val androidAnnotations = "androidx.annotation:annotation:${Versions.axAnnotation}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val roomRxJva = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.axAppcompat}"
}


object PresentationDependencies {
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val androidAnnotations = "androidx.annotation:annotation:${Versions.axAnnotation}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    val pagingVersion = "androidx.paging:paging-runtime:${Versions.paginLibVersion}"
    val pagingRxVersion = "androidx.paging:paging-rxjava2:${Versions.paginLibVersion}"
    val assistedInject =
        "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.assistedInjectVersion}"
    val assistedInjectProcessor =
        "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.assistedInjectVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val searchDailog="com.github.mirrajabi:search-dialog:${Versions.searchDailogVersion}"


}

object MobileUIDependencies {
    val circulerImageView = "de.hdodenhof:circleimageview:${Versions.circulerImageVersion}"
    val swipeReveal =
        "com.chauthai.swipereveallayout:swipe-reveal-layout:${Versions.swipeRevealVersion}"
    val rxLocation = "pl.charmas.android:android-reactive-location2:${Versions.rxLocationVersion}"
    val placesService =
        "com.google.android.libraries.places:places:${Versions.newPlacesServiceVersion}"
    val locationService =
        "com.google.android.gms:play-services-location:${Versions.locationServiceVersion}"
    val avLoading = "com.wang.avi:library:${Versions.avLoadingVersion}"
    val facebookSdk = "com.facebook.android:facebook-android-sdk:${Versions.facebookSdkVersion}"
    val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.axViewPager2Version}"
    val sdp = "com.intuit.sdp:sdp-android:${Versions.sdpVersion}"
    val accountKit = "com.facebook.android:account-kit-sdk:${Versions.accountKitVersion}"
    val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    val supportDesign = "com.android.support:design:${Versions.supportDesignVersion}"
    val axCardView = "androidx.cardview:cardview:${Versions.axCardViewVersion}"
    val multidex = "androidx.multidex:multidex:${Versions.multidexVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val ktx = "androidx.core:core-ktx:${Versions.axCorektx}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    val javaxAnnotations = "javax.annotation:jsr250-api:${Versions.javaxAnnotationVersion}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectionVersion}"
    val androidAnnotations = "androidx.annotation:annotation:${Versions.axAnnotation}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.axAppcompat}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.axRecyclerView}"
    val design = "com.google.android.material:material:${Versions.materialVersion}"
    val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    val dynamicanimation =
        "androidx.dynamicanimation:dynamicanimation:${Versions.dynamicanimation_version}"
    val glassfishAnnotation = "org.glassfish:javax.annotation:${Versions.glassFishVersion}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val roomRxJva = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    val appCompatSupport = "com.android.support:appcompat-v7:${Versions.appCompatVersion}"
    val pagingVersion = "androidx.paging:paging-runtime:${Versions.paginLibVersion}"
    val pagingRxVersion = "androidx.paging:paging-rxjava2:${Versions.paginLibVersion}"

    val assistedInject =
        "com.squareup.inject:assisted-inject-annotations-dagger2:${Versions.assistedInjectVersion}"
    val assistedInjectProcessor =
        "com.squareup.inject:assisted-inject-processor-dagger2:${Versions.assistedInjectVersion}"

    val playAuth = "com.google.android.gms:play-services-auth:${Versions.playServiceAuthVersion}"
    val okkHttpGlide = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideVersion}"

    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    val fragmentX = "androidx.fragment:fragment:${Versions.fragmentXversion}"
    val facebookLogin = "com.facebook.android:facebook-login:${Versions.fbLoginVersion}"
    val twitterSdk = "com.twitter.sdk.android:twitter:${Versions.twitterSdkVersion}"
    val twitterCore = "com.twitter.sdk.android:twitter-core:${Versions.twitterSdkVersion}"
    val stetho = "com.facebook.stetho:stetho:${Versions.stethoVersion}"
    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanaryVersion}"
    val searchDailog = "com.github.mirrajabi:search-dialog:${Versions.searchDailogVersion}"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalyticsVersion}"
    val firebaseConfig = "com.google.firebase:firebase-config:${Versions.firebaseConfigVersion}"
    val firebaseCrshlytics ="com.crashlytics.sdk.android:crashlytics:${Versions.firebaseCrashlyticsVersion}"
    val expandableRecycleView = "com.thoughtbot:expandablecheckrecyclerview:${Versions.expandableRecycleViewVersion}"
    val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessagingVersion}"
    val workManger = "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"
    val firebaseInAppMessaging ="com.google.firebase:firebase-inappmessaging-display:${Versions.firebaseInAppMessagingVersion}"
    val firebaseCore= "com.google.firebase:firebase-core:${Versions.firebaseCoreVersion}"
    val firebaseIid= "com.google.firebase:firebase-iid:${Versions.firebaseIidVersion}"
    val firebaseDynamicLinks="com.google.firebase:firebase-dynamic-links:${Versions.firebaseDynamicLinksVersion}"
    val calligraphy="uk.co.chrisjenx:calligraphy:${Versions.callgraphVersion}"
    val aviAnimation="com.wang.avi:library:${Versions.aviVersion}"
    val smartLook="com.smartlook.recording:app:${Versions.smartLookVersion}"


}

object ModelDependencies {
    val searchDailog="com.github.mirrajabi:search-dialog:${Versions.searchDailogVersion}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc"
}