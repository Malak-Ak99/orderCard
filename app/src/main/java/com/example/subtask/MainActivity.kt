package com.example.subtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var createEventButton: Button  // Button to navigate to CreateEventActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure this is your main layout file

        // Initialize the Create Event button
        createEventButton = findViewById(R.id.create_event_button)

        // Navigate to CreateEventActivity when Create Event button is clicked
        createEventButton.setOnClickListener {
            val intent = Intent(this, CreateEventActivity::class.java)
            startActivity(intent)
        }
    }
}
