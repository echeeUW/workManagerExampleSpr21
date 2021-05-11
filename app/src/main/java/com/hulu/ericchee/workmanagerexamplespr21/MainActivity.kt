package com.hulu.ericchee.workmanagerexamplespr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hulu.ericchee.workmanagerexamplespr21.databinding.ActivityMainBinding
import com.hulu.ericchee.workmanagerexamplespr21.manager.EmailSyncManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val weApp by lazy { application as WESApplication }
    private val emailSyncManager: EmailSyncManager by lazy { weApp.emailSyncManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnStart.setOnClickListener {
                // Execute work in the background

                emailSyncManager.syncEmails()

            }

        }
    }
}


