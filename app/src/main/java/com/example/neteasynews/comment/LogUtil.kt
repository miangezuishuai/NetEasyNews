package com.example.neteasynews.comment

import android.util.Log


object LogUtil {

    fun v(tag: String, msg: String) {
        if (API.DEBUG == true) {
            Log.v(tag, msg)
        }
    }

    fun d(tag: String, msg: String) {
        if (API.DEBUG == true) {
            Log.d(tag, msg)
        }
    }

    fun i(tag: String, msg: String) {
        if (API.DEBUG == true) {
            Log.i(tag, msg)
        }
    }

    fun w(tag: String, msg: String) {
        if (API.DEBUG == true) {
            Log.w(tag, msg)
        }
    }

    fun e(tag: String, msg: String) {
        if (API.DEBUG == true) {
            Log.e(tag, msg)
        }
    }
}