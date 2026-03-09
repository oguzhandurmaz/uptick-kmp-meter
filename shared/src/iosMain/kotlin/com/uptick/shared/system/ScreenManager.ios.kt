package com.uptick.shared.system

import platform.UIKit.UIApplication

actual fun keepScreenOn(enabled: Boolean) {
    UIApplication.sharedApplication.idleTimerDisabled = enabled
}