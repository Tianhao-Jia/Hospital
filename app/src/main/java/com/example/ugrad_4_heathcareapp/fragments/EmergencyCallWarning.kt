package com.example.ugrad_4_heathcareapp.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ugrad_4_heathcareapp.R
import com.google.firebase.firestore.FirebaseFirestore


class EmergencyCallWarning : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val db = FirebaseFirestore.getInstance();
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_emergency_call_warning, container, false)

        val buttonEmergencyCallYes = view.findViewById<Button>(R.id.btnYesCall);
        val buttonEmergencyCallNo = view.findViewById<Button>(R.id.btnNoCall);

        // No call => return to homepage
        buttonEmergencyCallNo.setOnClickListener {
            findNavController().navigate(R.id.action_emergencyCallWarning_to_homePage)
        }

        // Want to call => call 911
        buttonEmergencyCallYes.setOnClickListener {
            /**
             * Consulted the following resource for opening phone dialer for emergency call
             * URL:https://stackoverflow.com/questions/11699819/how-do-i-get-the-dialer-to-open-with-phone-number-displayed
             */
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911") // Purposely wrong
            startActivity(intent)
        }

        return view
    }
}