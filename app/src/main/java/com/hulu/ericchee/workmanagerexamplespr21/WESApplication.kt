package com.hulu.ericchee.workmanagerexamplespr21

import android.app.Application
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailNotificationManager
import com.hulu.ericchee.workmanagerexamplespr21.manager.RefreshEmailManager

class WESApplication: Application() {

    lateinit var refreshEmailManager: RefreshEmailManager
    lateinit var notificationManager: EmailNotificationManager

    override fun onCreate() {
        super.onCreate()

        this.refreshEmailManager = RefreshEmailManager(this)
        this.notificationManager = EmailNotificationManager(this)

    }
}
