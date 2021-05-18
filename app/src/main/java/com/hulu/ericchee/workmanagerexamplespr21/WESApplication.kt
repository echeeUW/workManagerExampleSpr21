package com.hulu.ericchee.workmanagerexamplespr21

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailNotificationManager
import com.hulu.ericchee.workmanagerexamplespr21.manager.RefreshEmailManager

const val EMAIL_APP_PREFS_KEY = "Email App Prefs"

class WESApplication: Application() {

    lateinit var refreshEmailManager: RefreshEmailManager
    lateinit var notificationManager: EmailNotificationManager
    lateinit var preferences: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        this.refreshEmailManager = RefreshEmailManager(this)
        this.notificationManager = EmailNotificationManager(this)
        this.preferences = getSharedPreferences(EMAIL_APP_PREFS_KEY, Context.MODE_PRIVATE)

    }
}
