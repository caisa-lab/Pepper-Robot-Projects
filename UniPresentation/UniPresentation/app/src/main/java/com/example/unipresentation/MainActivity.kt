package com.example.unipresentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /**
     * implementing buttons and adding an activity main layout
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_marburg_info.setOnClickListener {
            val intent = Intent(this, MarburgActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_uni_info.setOnClickListener {
            val intent = Intent(this, AboutUniversity::class.java)
            startActivity(intent)
            finish()
        }

        btn_infrastructure.setOnClickListener {
            val intent = Intent(this, InfrastructureActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}