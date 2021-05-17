package com.hulu.ericchee.workmanagerexamplespr21.manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.hulu.ericchee.workmanagerexamplespr21.R
import com.hulu.ericchee.workmanagerexamplespr21.activity.EMAIL_INFO_KEY
import com.hulu.ericchee.workmanagerexamplespr21.activity.EmailDetailActivity
import kotlin.random.Random

private const val NEW_EMAILS_CHANNEL_ID = "NEW_EMAILS_CHANNEL_ID"

class EmailNotificationManager(
    private val context: Context
) {
    private val notificationManager = NotificationManagerCompat.from(context)

    init {
        // Initialize all channels
        initNotificationChannels()
    }

    fun publishNewEmailNotification() {
        // Define the intent or action you want when user taps on notification
        val intent = Intent(context, EmailDetailActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(EMAIL_INFO_KEY, "This string is coming from the notification")
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT) // dont forget to add PendingIntent.FLAG_UPDATE_CURRENT to send data over


        // Build information you want the notification to show
        val builder = NotificationCompat.Builder(context, NEW_EMAILS_CHANNEL_ID)    // channel id from creating the channel
            .setSmallIcon(R.drawable.ic_email)
            .setContentTitle("New Email from Post Malone")
            .setContentText("You a SUN FLOWWWWWAAAAAAAAA ${Random.nextInt()}")
            .setContentIntent(pendingIntent)    // sets the action when user clicks on notification
            .setAutoCancel(true)    // This will dismiss the notification tap
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Tell the OS to publish the notification using the info
        with(notificationManager) {
            // notificationId is a unique int for each notification that you must define
            val notificationId = Random.nextInt()
            notify(notificationId, builder.build())
        }
    }

    private fun initNotificationChannels() {
        initNewEmailsChannel()
//        initPromotionChannel()
    }

    private fun initNewEmailsChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Info about the channel
            val name = context.getString(R.string.new_emails)
            val descriptionText = context.getString(R.string.new_emails_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            // Create channel object
            val channel = NotificationChannel(NEW_EMAILS_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Tell the Android OS to create a channel
            notificationManager.createNotificationChannel(channel)
        }
    }

//    private fun initPromotionChannel() {}

}
