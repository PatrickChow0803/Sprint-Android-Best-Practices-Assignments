package com.lambda.crash_assignment_patrick_chow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    lateinit var lateInit: String
    private var arrayOutOfBounds = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_first.setOnClickListener {
            dropBreadcrumb("Main Activity", "forceCrash", 0L, "Using the example Crashlytics gave.")
            Crashlytics.getInstance().crash()
        }

        btn_second.setOnClickListener {
            dropBreadcrumb("Main Activity", "forceCrashListener", 0L, "Button Click Force Crash")
            throw RuntimeException("This is a forced crash")
        }

        btn_third.setOnClickListener {
            dropBreadcrumb("Main Activity", "forceInitCrash", 0L, "Trying to set a value to something that isn't initialized yet")
            val crashLate: String = lateInit
        }

        btn_fourth.setOnClickListener {
            dropBreadcrumb("Main Activity", "force out of bounds", 0L, "Trying to assign a value that is out of bounds")
            arrayOutOfBounds[0] = 123
        }

    }
}