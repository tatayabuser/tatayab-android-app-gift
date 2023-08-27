package com.tatayab.tatayab.util

import android.content.Context
import android.media.MediaPlayer
import com.tatayab.tatayab.R

class SoundUtil {
    private var mp: MediaPlayer? = null

    companion object {
        private var soundUtil: SoundUtil? = null
        private var contxt: Context? = null

        fun getInstance(context: Context): SoundUtil {
            contxt = context
            if (soundUtil == null) {
                soundUtil = SoundUtil()
            }

            return soundUtil as SoundUtil
        }
    }

    fun playNotificationSound() {
        try {
            mp = MediaPlayer.create(contxt, R.raw.notification_sound)
            mp!!.isLooping = false
            mp!!.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}