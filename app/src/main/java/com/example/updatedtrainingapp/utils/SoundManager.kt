package com.example.updatedtrainingapp.utils

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import com.example.updatedtrainingapp.application.ThisApplication
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Михан on 24.05.2017.
 */
class SoundManager @Inject constructor(private val soundPool: SoundPool) {
    private var restOver = -1
    private var newRecord = -1

    fun loadSound() {
        try {
            val assetManager: AssetManager = ThisApplication.instance.assets
            var descriptor: AssetFileDescriptor
            descriptor = assetManager.openFd("PutThatCookieDown.ogg")
            restOver = soundPool.load(descriptor, 0)
            descriptor = assetManager.openFd("coin_pickup.ogg")
            newRecord = soundPool.load(descriptor, 0)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun playSound(sound: String?) {
        when (sound) {
            "PutThatCookieDown" -> soundPool.play(restOver, 1f, 1f, 0, 0, 1f)
            "coin_pickup.ogg" -> soundPool.play(newRecord, 1f, 1f, 0, 0, 1f)
        }
    }

    fun playPTCD() {
        soundPool.play(restOver, 1f, 1f, 0, 0, 1f)
    }

    fun playNewRecord() {
        soundPool.play(newRecord, 1f, 1f, 0, 0, 1f)
    }
}