package com.hulu.ericchee.workmanagerexamplespr21.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import androidx.work.impl.model.Preference
import com.hulu.ericchee.workmanagerexamplespr21.WESApplication
import com.hulu.ericchee.workmanagerexamplespr21.databinding.ActivityMainBinding
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailNotificationManager
import com.hulu.ericchee.workmanagerexamplespr21.manager.RefreshEmailManager


const val NOTIFICATIONS_ENABLED_PREF_KEY = "notifications_enabled"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val weApp by lazy { application as WESApplication }
    private val refreshEmailManager: RefreshEmailManager by lazy { weApp.refreshEmailManager }
    private val emailNotificationManager: EmailNotificationManager by lazy { weApp.notificationManager }
    private val preferences by lazy { weApp.preferences }

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

            switchNotificationsEnabled.isChecked = preferences.getBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, false)
            emailNotificationManager.isNotificationsEnabled = preferences.getBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, false)

            switchNotificationsEnabled.setOnCheckedChangeListener { _, isChecked ->
                emailNotificationManager.isNotificationsEnabled = isChecked

                // Saving the value in preferences whether the switch is on or not
                preferences.edit {
                    putBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, isChecked)
                }

                if (isChecked) {
                    Toast.makeText(this@MainActivity, "Notifications enabled", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Notifications are turned off", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}


