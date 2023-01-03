package com.example.ugrad_4_heathcareapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AddAppointmentActivity : AppCompatActivity() {
    lateinit  var etTitle: EditText
    lateinit var editTextTextMultiLine: EditText
    lateinit  var spHospital: Spinner
    lateinit var spReminder: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_appointment)
        etTitle = findViewById(R.id.etAppointmentTitle)
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine)
        spHospital = findViewById(R.id.spHospital)
        spReminder = findViewById(R.id.spReminder)
        findViewById<View>(R.id.bt_add).setOnClickListener {
            val title = etTitle.text.toString()
            val note = editTextTextMultiLine.text.toString()
            val hospital = spHospital.selectedItem.toString()
            val reminder = spReminder.selectedItem.toString()
            val datas = HashMap<String, Any?>()
            datas["title"] = title
            datas["note"] = note
            datas["hospital"] = spHospital.selectedItemPosition
            datas["reminder"] = spReminder.selectedItemPosition
            datas["uid"] = FirebaseAuth.getInstance().uid
            FirebaseDatabase.getInstance()
                .getReference("Appointment").push().setValue(datas)
            finish()
        }
    }
}