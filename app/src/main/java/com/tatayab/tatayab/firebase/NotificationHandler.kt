package com.tatayab.tatayab.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R


object NotificationHandler {
    val token = MutableLiveData<String>()

    @JvmStatic
    var mNotificationListener: NotificationListener? = null


    @JvmStatic
    fun sendNotification(
        context: Context,
        messageBody: String,
        title: String,
        data: MutableMap<String, String>
    ) {
        println("KKKKKKKK Message sendNotification()")

        lateinit var pendingIntent: PendingIntent
        val url = data["url"]?.trim()
        val bundle = Bundle()
        bundle.putString("url", url)
        pendingIntent = if (!data.isNullOrEmpty() && url != null) {
            val intentMain = Intent(context, MainActivity::class.java)
            val list = url.split("/")
            // "https://tatayab.com/EG-ar/category/50?type=category"
            when {
                url.contains("products", true) -> {
                    bundle.putString("productId", list[4])
                }
                url.contains("product-details", true) -> {
                    bundle.putString("productId", list[5])
                }
                url.contains("Categories", true) || url.contains("category", true) -> {
                    if (url.contains("type", true)) {
                        bundle.putString("categoryId", list[5])
                        bundle.putString("categoryName", context.getString(R.string.product_list))
                        if (url.contains("type=category", true)) {
                            bundle.putString("categoryType", "cid")
                        } else if (url.contains("type=brand", true)) {
                            bundle.putString("categoryType", "supplier_ids")
                        }
                    } else {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[4])
                        bundle.putString("categoryName", list[5])
                    }
                }
                url.contains("supplier", true) || url.contains("suppliers", true) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
            }
            intentMain.putExtras(bundle)
            intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            PendingIntent.getActivity(
                context, 0 /* Request code */, intentMain,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_ONE_SHOT
            )

        } else {// normal notification
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            PendingIntent.getActivity(
                context, 0 /* Request code */, intent,
                PendingIntent.FLAG_IMMUTABLE or  PendingIntent.FLAG_ONE_SHOT
            )
        }

        if (mNotificationListener != null) {
            mNotificationListener!!.showNotificationDialog(title, messageBody, bundle)
        } else {
            val channelId = context.getString(R.string.default_notification_channel_id)
            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setColor(ContextCompat.getColor(context, R.color.light_brown))
                .setLargeIcon(
                    generateBitmapFromVectorDrawable(
                        context,
                        R.drawable.ic_stat_notification
                    )
                )
                .setContentTitle(context.getString(R.string.fcm__notification_title))
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Since android Oreo notification channel is needed.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "Tatayab-Android",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
        }


    }

    fun generateBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
        val drawable = ContextCompat.getDrawable(context, drawableId) as Drawable
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }


    interface NotificationListener {
        fun showNotificationDialog(title: String, message: String, dataBundle: Bundle)
    }

}