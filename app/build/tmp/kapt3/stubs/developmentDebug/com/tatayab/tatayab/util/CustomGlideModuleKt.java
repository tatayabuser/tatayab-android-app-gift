package com.tatayab.tatayab.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"enableTls12OnPreLollipop", "Lokhttp3/OkHttpClient$Builder;", "client", "app_developmentDebug"})
public final class CustomGlideModuleKt {
    
    /**
     * Avoid following errors on pre-lollipop devices:
     *
     * class com.bumptech.glide.load.engine.GlideException: Failed to load resource
     * Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Fetching data failed, class java.io.InputStream, REMOTE
     * Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Fetch failed
     * Cause (1 of 1): class javax.net.ssl.SSLHandshakeException: javax.net.ssl.SSLProtocolException: SSL handshake aborted: ssl=0xb84fdb80: Failure in SSL library, usually a protocol error
     * error:1407742E:SSL routines:SSL23_GET_SERVER_HELLO:tlsv1 alert protocol version (external/openssl/ssl/s23_clnt.c:741 0x96f6f926:0x00000000)
     * W/Glide: Load failed for https://www.legalzoom.com/sites/legalzoom.com/files/uploaded/attorney/atty-258.jpg with size [100x100]
     */
    @org.jetbrains.annotations.NotNull
    public static final okhttp3.OkHttpClient.Builder enableTls12OnPreLollipop(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient.Builder client) {
        return null;
    }
}