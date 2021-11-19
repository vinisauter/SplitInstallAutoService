package com.splitinstall.auto.service

import android.app.Application
import android.injection.get
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import java.io.File

fun getString(resId: Int): String {
    val app: Application = get()
    return app.getString(resId)
}

fun getExternalFilesDir(type: String): File? {
    val app: Application = get()
    return app.getExternalFilesDir(type)
}

fun getAppFolder(folder: String): File {
    val app: Application = get()
    return File(app.filesDir, folder)
}

fun longToast(text: CharSequence) {
    val app: Application = get()
    Handler(Looper.getMainLooper()).post { Toast.makeText(app, text, Toast.LENGTH_LONG).show() }
}

fun shortToast(text: CharSequence) {
    val app: Application = get()
    Handler(Looper.getMainLooper()).post { Toast.makeText(app, text, Toast.LENGTH_SHORT).show() }
}