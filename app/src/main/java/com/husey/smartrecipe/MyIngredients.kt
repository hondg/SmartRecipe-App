package com.husey.smartrecipe

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.husey.smartrecipe.databinding.FragmentMyIngredientsBinding


class MyIngredients : Fragment() {
    private var _binding: FragmentMyIngredientsBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyIngredientsBinding.inflate(inflater, container, false)
        sharedPreferences = requireContext().getSharedPreferences("notes", Context.MODE_PRIVATE)
        val savedNotes = sharedPreferences.getString("notes_key", "")
        binding.savedNotesTextView.text = savedNotes

        binding.saveNotesButton.setOnClickListener {
            val notes = binding.notesEditText.text.toString()
            appendAndSaveNotes(notes)
        }
        binding.deleteNotesButton.setOnClickListener {
            deleteNotes()
        }

        // Inflate the layout for this fragment
        return binding.root
    }
    private fun appendAndSaveNotes(newNote: String) {
        // Get existing notes from SharedPreferences
        val existingNotes = sharedPreferences.getString("notes_key", "")
        // Append the new note to the existing notes
        val updatedNotes = if (existingNotes.isNullOrEmpty()) {
            newNote
        } else {
            "$existingNotes\n$newNote"
        }
        // Save the updated notes back to SharedPreferences
        with(sharedPreferences.edit()) {
            putString("notes_key", updatedNotes)
            apply()
        }
        // Update the TextView with the updated notes
        binding.savedNotesTextView.text = updatedNotes
        // Clear the EditText
        binding.notesEditText.text.clear()
    }
    private fun deleteNotes() {
        // Clear the notes from SharedPreferences
        with(sharedPreferences.edit()) {
            remove("notes_key")
            apply()
        }
        // Update the TextView to show no notes
        binding.savedNotesTextView.text = ""
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}