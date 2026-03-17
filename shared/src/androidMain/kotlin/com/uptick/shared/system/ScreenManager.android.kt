package com.uptick.shared.system

import android.app.Activity
import android.view.WindowManager

lateinit var currentActivity: Activity

actual fun keepScreenOn(
    enabled: Boolean
) {

    val window = currentActivity.window

    if (enabled) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}