package com.forecastapp.utils

import timber.log.Timber

class LogUtils {

    companion object {

        fun v(tag: String, message: String) {
            Timber.v(tag, message)
        }
    }
}