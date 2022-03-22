package com.internshal.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengerActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avenger)
        title="The Avengers"

        if(intent != null){

            titleName = intent.getStringExtra("Name")
            title = titleName
        }

    }




}
