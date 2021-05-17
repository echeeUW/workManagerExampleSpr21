package com.hulu.ericchee.workmanagerexamplespr21.manager

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

private const val EMAIL_SYNC_WORK_TAG = "EMAIL_SYNC_WORK_TAG"

class RefreshEmailManager(context: Context) {

    private val workManager: WorkManager = WorkManager.getInstance(context)

    fun refreshEmails() {

        val request = OneTimeWorkRequestBuilder<EmailSyncWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .addTag(EMAIL_SYNC_WORK_TAG)
            .build()

        workManager.enqueue(request)
    }

    fun startRefreshEmailsPeriodically() {
        if (isEmailSyncRunning()) {
            return
        }

        val request = PeriodicWorkRequestBuilder<EmailSyncWorker>(15, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresCharging(true)
                    .build()
            )
            .addTag(EMAIL_SYNC_WORK_TAG)
            .build()

        workManager.enqueue(request)

    }

    fun stopPeriodicallyRefreshing() {
        workManager.cancelAllWorkByTag(EMAIL_SYNC_WORK_TAG)
    }

    private fun isEmailSyncRunning(): Boolean {
        return workManager.getWorkInfosByTag(EMAIL_SYNC_WORK_TAG).get().any {
            when(it.state) {
                WorkInfo.State.RUNNING,
                WorkInfo.State.ENQUEUED -> true
                else -> false
            }
        }
    }




}
