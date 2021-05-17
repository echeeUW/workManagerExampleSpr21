package com.hulu.ericchee.workmanagerexamplespr21.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hulu.ericchee.workmanagerexamplespr21.databinding.ActivityEmailDetailBinding

const val EMAIL_INFO_KEY = "EMAIL_INFO_KEY"

class EmailDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            tvEmailInfo.text = intent.getStringExtra(EMAIL_INFO_KEY)

        }
    }
}
