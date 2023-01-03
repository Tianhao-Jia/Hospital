package com.example.ugrad_4_heathcareapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ugrad_4_heathcareapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomePage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        val buttonEmergencyCallWarning = view.findViewById<FloatingActionButton>(R.id.fltBtnEmergencyCall)
        val btnHpLogin = view.findViewById<Button>(R.id.btnHpLogin)
        val btnHpRegister = view.findViewById<Button>(R.id.btnHpRegister)
        btnHpLogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        btnHpRegister.setOnClickListener {
            findNavController().navigate(R.id.registerPage1)
        }
        // Setting on click listener on floating btn
        buttonEmergencyCallWarning.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_emergencyCallWarning)
        }


        // Modify Add button image
        buttonEmergencyCallWarning.setImageResource(android.R.drawable.ic_menu_call)


        return view
    }


}