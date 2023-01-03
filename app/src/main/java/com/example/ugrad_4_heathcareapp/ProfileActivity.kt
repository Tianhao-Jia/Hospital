package com.example.ugrad_4_heathcareapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.ugrad_4_heathcareapp.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {
   lateinit var firstNameInput: EditText
    lateinit  var lastNameInput: EditText
    lateinit var emailInput: EditText
    lateinit  var locationInput: EditText
    lateinit var phoneNumberInput: EditText
    lateinit  var spinner1: Spinner
    private var key: String? = null
    private var myModel: UserModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_crud_profile)
        firstNameInput = findViewById(R.id.firstNameInput)
        lastNameInput = findViewById(R.id.lastNameInput)
        emailInput = findViewById(R.id.emailInput)
        phoneNumberInput = findViewById(R.id.phoneNumberInput)
        locationInput = findViewById(R.id.locationInput)
        spinner1 = findViewById(R.id.spinner1)
        val mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        val myDf = FirebaseDatabase.getInstance().reference.child("User").child(
            user!!.uid
        )
        myDf.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                 myModel = dataSnapshot.getValue(UserModel::class.java)
                myModel?.let {
                    key = dataSnapshot.key
                    firstNameInput.setText(myModel!!.firstName)
                    lastNameInput.setText(it.lastName)
                    emailInput.setText(it.email)
                    phoneNumberInput.setText(it.phoneNum)
                    locationInput.setText(it.location)
                    if (myModel!!.role == "Patient") {
                        spinner1.setSelection(0)
                    } else {
                        spinner1.setSelection(1)
                    }
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        findViewById<View>(R.id.saveBtn).setOnClickListener {
            val firstName = firstNameInput.text.toString()
            val lastName = lastNameInput.text.toString()
            val email = emailInput.text.toString()
            val phoneNum = phoneNumberInput.text.toString()
            val location = locationInput.text.toString()
            val role = spinner1.selectedItem.toString()
            myModel?.let {
                var user = HashMap<String,Any?>()
                user["firstName"] = firstName
                user["lastName"] = lastName
                user["email"] = email
                user["id"] = it.id
                user["phoneNum"] = phoneNum
                user["role"] = role
                user["pwd"] = it.pwd
                user["location"] = location
                key?.let { it1 ->
                    FirebaseDatabase.getInstance()
                        .getReference("User").child(it1).setValue(user)
                }
            }

        }
    }
}