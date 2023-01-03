package com.example.ugrad_4_heathcareapp.model

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AppointmentLstSingleton(appointmentLst: Resources) {
    // Declaring two list (one original, one to hold live data
    private val startingNotesList = appointmentLst(appointmentLst)
    private val notesListLiveData = MutableLiveData(startingNotesList)

    /**
     * Adds a appointment to the list
     */
    fun addAppointment(note: AppointmentObj) {
        val currentList = notesListLiveData.value
        if(currentList == null) {
            notesListLiveData.postValue(listOf(note))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, note)
            notesListLiveData.postValue(updatedList)
        }
    }

    /**
     * Gets the list of notes
     */
    fun getNotesList(): LiveData<List<AppointmentObj>> {
        return notesListLiveData
    }

    /**
     * Returns the size of the list
     */
    fun getNotesLstSize(): Int? {
        return notesListLiveData.value?.size
    }

    /**
     * Initializes the NotesLstSingleton only once
     */
    companion object {
        private var INSTANCE: AppointmentLstSingleton? = null

        fun getNotesLstSingleton(resources: Resources): AppointmentLstSingleton {
            return synchronized(AppointmentLstSingleton::class) {
                val newInstance = INSTANCE ?: AppointmentLstSingleton(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}