package com.hulu.ericchee.workmanagerexamplespr21.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hulu.ericchee.workmanagerexamplespr21.WESApplication
import com.hulu.ericchee.workmanagerexamplespr21.databinding.ActivityMainBinding
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailNotificationManager
import com.hulu.ericchee.workmanagerexamplespr21.manager.RefreshEmailManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val weApp by lazy { application as WESApplication }
    private val refreshEmailManager: RefreshEmailManager by lazy { weApp.refreshEmailManager }
    private val emailNotificationManager: EmailNotificationManager by lazy { weApp.notificationManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnStart.setOnClickListener {
                // Execute work in the background
                refreshEmailManager.refreshEmails()
            }

            btnStartPeriodic.setOnClickListener {
                refreshEmailManager.startRefreshEmailsPeriodically()
            }

            btnStop.setOnClickListener {
                refreshEmailManager.stopPeriodicallyRefreshing()
            }

            btnPublishNotification.setOnClickListener {
                emailNotificationManager.publishNewEmailNotification()
            }

        }
    }
}


