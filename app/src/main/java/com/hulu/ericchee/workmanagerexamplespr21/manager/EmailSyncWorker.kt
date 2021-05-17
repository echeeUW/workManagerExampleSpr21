package com.hulu.ericchee.workmanagerexamplespr21.manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hulu.ericchee.workmanagerexamplespr21.WESApplication

class EmailSyncWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val application by lazy { context.applicationContext as WESApplication }
    private val emailNotificationManager by lazy { application.notificationManager }

    override suspend fun doWork(): Result {

        Log.i("EmailSyncWorker", "syncing emails now")
        emailNotificationManager.publishNewEmailNotification()

        return Result.success()
    }


}
