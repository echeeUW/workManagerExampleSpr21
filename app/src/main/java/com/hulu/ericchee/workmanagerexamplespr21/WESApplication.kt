package com.hulu.ericchee.workmanagerexamplespr21

import android.app.Application
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailSyncManager

class WESApplication: Application() {

    lateinit var emailSyncManager: EmailSyncManager

    override fun onCreate() {
        super.onCreate()

        this.emailSyncManager = EmailSyncManager(this)

    }
}
