package com.kangmin.meew.util

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

object FlipperUtil {

    val networkFlipperPlugin = NetworkFlipperPlugin()

    fun init(application: Application) {
        try {
            SoLoader.init(application, false)
            AndroidFlipperClient.getInstance(application).apply {
                addPlugin(InspectorFlipperPlugin(application, DescriptorMapping.withDefaults()))
                addPlugin(networkFlipperPlugin)
            }.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}