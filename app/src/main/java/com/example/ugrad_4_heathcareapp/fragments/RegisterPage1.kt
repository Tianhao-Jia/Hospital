package com.example.ugrad_4_heathcareapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ugrad_4_heathcareapp.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterPage1.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterPage1 : Fragment() {
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etId: EditText
    private lateinit  var rootView: View

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etFirstName =  rootView.findViewById<EditText>(R.id.etFirstName);
        etLastName =  rootView.findViewById<EditText>(R.id.etLastName);
        etEmail =  rootView.findViewById<EditText>(R.id.etEmail);
        etPhoneNumber =  rootView.findViewById<EditText>(R.id.etPhoneNumber);
        etId =  rootView.findViewById<EditText>(R.id.etId)
        rootView.findViewById<Button>(R.id.btn_login).setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        rootView.findViewById<Button>(R.id.btn_sign)
            .setOnClickListener {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val email = etEmail.text.toString()
                val phoneNum = etPhoneNumber.text.toString()
                val id = etId.text.toString()
                val args = Bundle()
                args.putString("firstName", firstName)
                args.putString("lastName", lastName)
                args.putString("email", email)
                args.putString("id", id)
                args.putString("phoneNum", phoneNum)
                findNavController()
                    .navigate(R.id.registerPage2, args)
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_register_page1, container, false)
        return rootView;
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterPage1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterPage1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}