package com.tatayab.remote.interceptor

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.tatayab.model.ResponseLogOnFireBase
import com.tatayab.model.common.NetworkExceptions
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.remote.FireBaseDataBase.FirebaseDataBaseRealTimeManager
import com.tatayab.remote.util.NetworkUtils
import okhttp3.*
import okio.Buffer
import okio.GzipSource
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.inject.Inject

class ConnectivityInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {
    var fireBaseLog:ResponseLogOnFireBase? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!NetworkUtils.isOnline(context = context)) {
            Log.e("Error in Connection", NetworkExceptions.NO_INTERNET.toString())
            //internetConnectionListener.onInternetUnavailable()
        }
          fireBaseLog = ResponseLogOnFireBase

        val response = chain.proceed(request)
        val contentType = response.body()!!.contentType()

        //response.body().readString(UTF8)
        val obj = request.body() to String()

        try {
            val responseString = responseBody(request, response)
            if (responseString != null) {

                fireBaseLog?.requestUrl = request.url().toString()
                fireBaseLog?.apiMethod = request.method()
                fireBaseLog?.requestBody = requesteBody(request.body()).toString()
                if (response.code() != 200) {
                    fireBaseLog?.error = responseString
                }else{
                    fireBaseLog?.requestResponse = responseString
                }

                if(fireBaseLog != null) FirebaseDataBaseRealTimeManager().logRequest(fireBaseLog!!)

                val obj = JSONObject(responseString)
                var status: Int? = null
                var message: String? = null
                if (obj.has("status")) {
                    status = obj.getInt("status")
                }
                if (obj.has("message")) {
                    message = obj.getString("message")
                }
                if (TextUtils.isEmpty(message)) {
                    val body = ResponseBody.create(contentType, obj.toString())
                    return response.newBuilder().code(200).body(body).build()
                }

            }
        } catch (e: Exception) {
            Log.d("http: request Exception", e.message.toString())
        }


        /* if (response.code() in 400..500) {
              val body = ResponseBody.create(contentType, JSONObject(responseBody(request, response)).toString())
              return response.newBuilder().code(200).body(body).removeHeader("Authorization").build()

            /* val obj = JSONObject(responseBody(request, response))
             throw ErrorResponseException(
                 NetworkExceptions.RESPONSE_ERROR,
                 ResponseError(message = obj.optString("message"), status = obj.optInt("status"))
             )*/
         }*/

        return response
    }

    private fun responseBody(request: Request, response: Response): String? {

        try {
            val headers = request.headers()
            val responseBody = response.body()
            val contentLength = responseBody?.contentLength()
            val bodySize = if (contentLength != -1L) "$contentLength-byte" else "unknown-length"


            val source = responseBody?.source()
            source?.request(Long.MAX_VALUE) // Buffer the entire body.
            var buffer = source!!.buffer()

            var gzippedLength: Long? = null
            if ("gzip".equals(headers["Content-Encoding"], ignoreCase = true)) {
                gzippedLength = buffer!!.size()
                GzipSource(buffer.clone()).use { gzippedResponseBody ->
                    buffer = Buffer()
                    buffer!!.writeAll(gzippedResponseBody)
                }
            }

            Log.d("body url", buffer.clone().readString(UTF8))
            return buffer.clone().readString(UTF8)
        } catch (e: Exception) {
            Log.d("parseError ", e.toString())
            return null
        }
    }


    private fun requesteBody(request: RequestBody?): String? {

        try {
            val contentLength = request?.contentLength()
            val bodySize = if (contentLength != -1L) "$contentLength-byte" else "unknown-length"

            var buffer = Buffer()
            request?.writeTo(buffer)
            // source?.request(Long.MAX_VALUE) // Buffer the entire body.

//            var gzippedLength: Long? = null
//            gzippedLength = buffer!!.size()
//            GzipSource(buffer.clone()).use { gzippedResponseBody ->
//               // buffer = Buffer()
//                buffer.writeAll(gzippedResponseBody)
//            }

            Log.d("body url", buffer.clone().readString(UTF8))
            return buffer.clone().readString(UTF8)
        } catch (e: Exception) {
            Log.d("parseError ", e.toString())
            return null
        }
    }

    private companion object {
        val UTF8: Charset = Charset.forName("UTF-8")
    }
}