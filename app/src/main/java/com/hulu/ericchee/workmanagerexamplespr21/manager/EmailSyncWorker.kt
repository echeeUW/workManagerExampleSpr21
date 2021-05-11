package com.hulu.ericchee.workmanagerexamplespr21.manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class EmailSyncWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {


    override suspend fun doWork(): Result {

        Log.i("EmailSyncWorker", "syncing emails now")

        return Result.success()
    }


}
