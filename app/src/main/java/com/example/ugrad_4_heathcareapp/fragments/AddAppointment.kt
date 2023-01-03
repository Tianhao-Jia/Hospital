package com.example.ugrad_4_heathcareapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ugrad_4_heathcareapp.R
import com.google.firebase.firestore.FirebaseFirestore


class AddAppointment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        // Create a new user with a first and last name
//        val use: MutableMap<String, Any> = HashMap()
//        user["first"] = "Ada"
//        user["last"] = "Lovelace"
//        user["born"] = 1815

// Add a new document with a generated ID

// Add a new document with a generated ID
//        db.collection("users")
//            .add(user)
//            .addOnSuccessListener { documentReference ->
//                Log.d(
//                    TAG,
//                    "DocumentSnapshot added with ID: " + documentReference.id
//                )
//            }
//            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
        return inflater.inflate(R.layout.fragment_add_appointment, container, false)
    }
}