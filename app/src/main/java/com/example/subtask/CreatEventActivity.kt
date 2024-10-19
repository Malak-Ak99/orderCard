package com.example.subtask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateEventActivity : AppCompatActivity() {

    // Declare your UI components
    private lateinit var orderTypeGroup: RadioGroup
    private lateinit var restaurantNameTextView: EditText // Ensure this is an EditText for input
    private lateinit var deadlineInput: EditText
    private lateinit var pickupOption: RadioButton
    private lateinit var eatAtRestaurantOption: RadioButton
    private lateinit var etaInput: EditText
    private lateinit var restaurantRatingInput: EditText
    private lateinit var foodRatingInput: EditText
    private lateinit var createEventButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        // Initialize UI components
        orderTypeGroup = findViewById(R.id.order_type_group)
        restaurantNameTextView = findViewById(R.id.restaurant_name)
        deadlineInput = findViewById(R.id.deadline_input)
        pickupOption = findViewById(R.id.pickup_option)
        eatAtRestaurantOption = findViewById(R.id.eat_at_restaurant_option)
        etaInput = findViewById(R.id.eta_input)
        restaurantRatingInput = findViewById(R.id.restaurant_rating_input)
        foodRatingInput = findViewById(R.id.food_rating_input)
        createEventButton = findViewById(R.id.create_event_button)

        // Set OnCheckedChangeListener to handle visibility of ETA input
        orderTypeGroup.setOnCheckedChangeListener { _, checkedId ->
            // Ensure this function returns Unit; don't attempt to use its result
            if (checkedId == R.id.pickup_option) {
                etaInput.visibility = View.VISIBLE // Show ETA input
            } else {
                etaInput.visibility = View.GONE // Hide ETA input
                etaInput.text.clear() // Clear ETA input when hidden
            }
        }

        // Set an OnClickListener for the Create Event button
        createEventButton.setOnClickListener {
            handleCreateEventClick()
        }
    }

    private fun handleCreateEventClick() {
        // Get user inputs from UI components
        val restaurantName = restaurantNameTextView.text.toString().trim()
        val deadline = deadlineInput.text.toString().trim()
        val eta = etaInput.text.toString().trim()
        val restaurantRating = restaurantRatingInput.text.toString().trim()
        val foodRating = foodRatingInput.text.toString().trim()

        // Determine the selected order type
        val orderType = when {
            pickupOption.isChecked -> "Pickup"
            eatAtRestaurantOption.isChecked -> "Eat at Restaurant"
            else -> "Unknown"
        }

        // Input validation
        when {
            restaurantName.isEmpty() -> {
                showToast("Please enter the restaurant name.")
                return
            }
            deadline.isEmpty() -> {
                showToast("Please enter the order deadline.")
                return
            }
            restaurantRating.isEmpty() -> {
                showToast("Please provide a restaurant rating.")
                return
            }
            foodRating.isEmpty() -> {
                showToast("Please provide a food rating.")
                return
            }
            orderType == "Pickup" && eta.isEmpty() -> {
                showToast("Please enter the ETA.")
                return
            }
        }

        // Log for debugging
        Log.d("CreateEventActivity", "Restaurant Name: $restaurantName, Order Type: $orderType, ETA: $eta")

        // Pass data to OrderSummaryActivity
        val intent = Intent(this, OrderSummaryActivity::class.java).apply {
            putExtra("restaurant_name", restaurantName)
            putExtra("order_type", orderType)
            putExtra("eta", eta)
            putExtra("deadline", deadline)
            putExtra("restaurant_rating", restaurantRating)
            putExtra("food_rating", foodRating)
        }
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
