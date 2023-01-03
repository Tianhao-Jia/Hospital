package com.example.ugrad_4_heathcareapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ugrad_4_heathcareapp.persistance.HomeAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AppointmentListActivity : AppCompatActivity() {
    private lateinit  var recyclerview: RecyclerView
    private lateinit var mAdapter: HomeAdapter
    private val list: MutableList<Appointment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        mAdapter = HomeAdapter(this, list)
        recyclerview.adapter = mAdapter
        mAdapter.setOnItemClickListener(object : HomeAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val appointment = list[position]
                val intent = Intent(this@AppointmentListActivity, AppointmentDetailActivity::class.java)
                intent.putExtra("data", appointment)
                startActivity(intent)
            }

        })
        init()
    }

    private fun init() {

        val  databaseReference = FirebaseDatabase.getInstance().reference.child("Appointment")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()
                for (snapshot in dataSnapshot.children) {
                    val appointment = snapshot.getValue(Appointment::class.java)
                    appointment?.let {
                        appointment.key = snapshot.key
                        if (FirebaseAuth.getInstance().uid == appointment.uid) {
                            list.add(appointment)
                        }
                    }

                }
                mAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}