package com.tatayab.tatayab.util

import android.content.Context
import android.os.Build
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser
import com.bumptech.glide.module.AppGlideModule
import com.tatayab.model.common.Tls12SocketFactory
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.TlsVersion
import java.io.InputStream
import java.security.KeyStore
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
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
fun enableTls12OnPreLollipop(client: OkHttpClient.Builder): OkHttpClient.Builder {
    if (Build.VERSION.SDK_INT in 18..21) {
        try {

            val trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm())
            trustManagerFactory.init(null as KeyStore?)
            val trustManagers = trustManagerFactory.trustManagers
            if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
                throw IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers))
            }
            val trustManager = trustManagers[0] as X509TrustManager

            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, arrayOf<TrustManager>(trustManager), null)

            val sc = SSLContext.getInstance("TLSv1.2")
            sc.init(null, null, null)
            client.sslSocketFactory(Tls12SocketFactory(sc.socketFactory), trustManager)

            val cs = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .build()

            val specs = arrayListOf<ConnectionSpec>()
            specs.add(cs)
            specs.add(ConnectionSpec.COMPATIBLE_TLS)
            specs.add(ConnectionSpec.CLEARTEXT)

            client.connectionSpecs(specs)
        } catch (exc: Throwable) {
            Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", exc)
        }

    }

    return client
}

/**
 * Customize Glide module:
 *
 * Especially enable TLS12 on pre-lollipop devices.
 * https://github.com/square/okhttp/issues/2372
 * https://bumptech.github.io/glide/doc/getting-started.html#applications
 */
@GlideModule
class CustomGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .cache(null)
            .protocols(listOf(Protocol.HTTP_1_1))
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)

        //Hack to fix Glide outputting tons of log spam with ExifInterface errors
        glide.registry.imageHeaderParsers.removeAll { it is ExifInterfaceImageHeaderParser }

        val factory = OkHttpUrlLoader.Factory(enableTls12OnPreLollipop(clientBuilder).build())

        registry.replace(GlideUrl::class.java, InputStream::class.java, factory)
    }


}