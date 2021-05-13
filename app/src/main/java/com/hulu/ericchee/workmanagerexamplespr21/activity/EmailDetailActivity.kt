package com.hulu.ericchee.workmanagerexamplespr21.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hulu.ericchee.workmanagerexamplespr21.databinding.ActivityEmailDetailBinding

class EmailDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

//            tvEmailInfo

        }
    }
}
