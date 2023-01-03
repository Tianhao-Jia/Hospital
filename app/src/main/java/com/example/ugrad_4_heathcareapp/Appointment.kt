package com.example.ugrad_4_heathcareapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Appointment(var title: String? = "", var note: String? = "", var hospital: Int=0
, var reminder: Int=0, var uid: String? = "",
                    var key: String? = ""):java.io.Serializable{
 }
