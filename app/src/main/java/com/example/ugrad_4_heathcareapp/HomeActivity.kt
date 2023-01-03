package com.example.ugrad_4_heathcareapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<View>(R.id.iv_info)
            .setOnClickListener {
                startActivity(
                    Intent(
                        this@HomeActivity,
                        ProfileActivity::class.java
                    )
                )
            }
        findViewById<View>(R.id.bt_add)
            .setOnClickListener {
                startActivity(
                    Intent(
                        this@HomeActivity,
                        AddAppointmentActivity::class.java
                    )
                )
            }
        findViewById<View>(R.id.bt_list)
            .setOnClickListener {
                startActivity(
                    Intent(
                        this@HomeActivity,
                        AppointmentListActivity::class.java
                    )
                )
            }
    }
}