package com.hulu.ericchee.workmanagerexamplespr21.manager

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class EmailSyncManager(context: Context) {

    private val workManager: WorkManager = WorkManager.getInstance(context)

    fun syncEmails() {

        val request = OneTimeWorkRequestBuilder<EmailSyncWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()

        workManager.enqueue(request)

    }


}
