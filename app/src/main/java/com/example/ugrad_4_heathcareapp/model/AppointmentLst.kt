package com.example.ugrad_4_heathcareapp.model

import android.content.res.Resources

/**
 * Returns a list to hold notes [NoteObj]
 */
fun appointmentLst(resources: Resources): List<AppointmentObj> {
    // Consulted https://github.com/android/views-widgets-samples/tree/main/RecyclerViewKotlin
    return listOf(
        // Note objs will be added here. A sample is provided
        // Sample Note details taken from: https://www.loremipsums.nl/lorem-ipsum-origineel/star-wars-ipsum/
        AppointmentObj(
            id = 1,
            title = "First"
        )
    )
}