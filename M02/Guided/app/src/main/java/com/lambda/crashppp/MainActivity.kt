package com.lambda.crashppp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_force_crash.setOnClickListener {
            dropBreadcrumb("MainActivity", "forceCrashListener", 0L, "Button Click Force Crash")
            throw RuntimeException("This is a forced crash")
        }

        btn_other_activity.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }
    }
}
