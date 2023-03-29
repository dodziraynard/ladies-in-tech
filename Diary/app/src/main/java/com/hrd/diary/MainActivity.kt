package com.hrd.diary

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hrd.diary.databinding.ActivityMainBinding
import com.hrd.diary.models.Note

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val noteTitle = binding.noteTitleInput.text.toString()
            val content = binding.noteContentInput.text.toString()

            val note = Note(title = noteTitle, content = content)

            AppDatabase.getDatabase(application)?.databaseWriteExecutor?.execute {
                AppDatabase.getDatabase(application)?.noteDao()?.insertNote(note)
                AppDatabase.getDatabase(application)?.noteDao()?.getNotes()
            }

            Toast.makeText(this, "Saved successfully", Toast.LENGTH_LONG).show()
            binding.noteTitleInput.text = Editable.Factory.getInstance().newEditable("")
            binding.noteContentInput.text = Editable.Factory.getInstance().newEditable("")
        }
    }
}