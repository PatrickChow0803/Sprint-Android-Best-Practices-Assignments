package com.lambda.analytics.patrickchow20191030

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseAnalytics.getInstance(this).setCurrentScreen(this, "MainActivity","test2")


        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1")
        bundle.putString(FirebaseAnalytics.Param.QUANTITY, "42")
        FirebaseAnalytics.getInstance(this).logEvent("Text_View_Clicked", bundle)
    }
}
