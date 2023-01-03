package com.example.ugrad_4_heathcareapp.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.ugrad_4_heathcareapp.HomeActivity
import com.example.ugrad_4_heathcareapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterPage2.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterPage2 : Fragment() {
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etLocation: EditText
    private lateinit var spRole: Spinner
    private lateinit var rootView: View

    // TODO: Rename and change types of parameters
    private var firstName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var id: String? = null
    private var phoneNum: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString("firstName")
            lastName = it.getString("lastName")
            email = it.getString("email")
            id = it.getString("id")
            phoneNum = it.getString("phoneNum")


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etPassword =   rootView.findViewById<EditText>(R.id.etPassword)
        etConfirmPassword = rootView.findViewById<EditText>(R.id.etConfirmPassword)
        etLocation  = rootView.findViewById<EditText>(R.id.etLocation)
        spRole  =rootView.findViewById<Spinner>(R.id.spRole)
        rootView.findViewById<Button>(R.id.btn_register).setOnClickListener {
            val pwd = etPassword.text.toString()
            val pwdAgain = etConfirmPassword.text.toString()
            val localtion = etLocation.text.toString()
            val role = spRole.selectedItem.toString()
            if (TextUtils.isEmpty(pwd)){
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(pwdAgain)){
                return@setOnClickListener
            }
            if (pwd != pwdAgain){
                return@setOnClickListener
            }
            email?.let {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(it,pwd)
                    .addOnCompleteListener {
                        var user = HashMap<String,Any?>()
                        user["firstName"] = firstName
                        user["lastName"] = lastName
                        user["email"] = email
                        user["id"] = id
                        user["phoneNum"] = phoneNum
                        user["role"] = role
                        user["pwd"] = pwd
                        user["location"] = localtion
                        FirebaseAuth.getInstance().uid?.let { it1 ->
                            FirebaseDatabase.getInstance()
                                .getReference("User").child(it1).setValue(user)
                        }
                        startActivity(Intent(activity,HomeActivity::class.java))
                    }
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_register_page2, container, false)
        return rootView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterPage2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterPage2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}