package com.example.ugrad_4_heathcareapp.persistance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ugrad_4_heathcareapp.R
import com.example.ugrad_4_heathcareapp.model.AppointmentLstSingleton
import com.example.ugrad_4_heathcareapp.model.AppointmentObj

//ToDO: Add appointment information later
class AppointmentAdapter(private val appointmentLstSingleton: AppointmentLstSingleton) :
    RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(noteView: View) : RecyclerView.ViewHolder(noteView) {
//            private val tvNoteTitle: TextView
//            private val tvNoteBody: TextView
            private var thisNote: AppointmentObj? = null

            init {
//                tvNoteTitle = noteView.findViewById(R.id.tvNoteTitleItem)
//                tvNoteBody = noteView.findViewById(R.id.tvNoteBodyItem)
            }

            // Linking title and body to the note_item layout
            fun bind(noteItem: AppointmentObj) {
                thisNote = noteItem
//                tvNoteTitle.text = noteItem.title
//                tvNoteBody.text = noteItem.body
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.appointment_item, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.bind(appointmentLstSingleton.getNotesList().value!![position])
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount(): Int = appointmentLstSingleton.getNotesLstSize()!!
}