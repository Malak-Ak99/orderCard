package com.example.subtask

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var scrollView: ScrollView
    private lateinit var menuSection: LinearLayout
    private lateinit var reviewsSection: LinearLayout
    private lateinit var commentsSection: LinearLayout
    private lateinit var swishSection: LinearLayout
    private lateinit var menuButton: Button
    private lateinit var reviewsButton: Button
    private lateinit var add_comment_button: EditText
    private lateinit var commentsList: LinearLayout
    private lateinit var commentsScrollView: ScrollView
    private lateinit var scrollUpButton: Button
    private lateinit var scrollDownButton: Button
    private lateinit var addCommentEditText: EditText
    private val comments = mutableListOf<String>()

    private lateinit var commentsButton: Button
    private lateinit var swishButton: Button
    private lateinit var orderSummaryText: TextView

    // TextViews for displaying passed data
    private lateinit var restaurantNameTextView: TextView
    private lateinit var orderTypeTextView: TextView
    private lateinit var etaTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)  // Replace with your XML layout if necessary

        // Initialize the ScrollView and sections
        scrollView = findViewById(R.id.main_scroll_view)
        menuSection = findViewById(R.id.menu_section)
        reviewsSection = findViewById(R.id.reviews_section)
        commentsSection = findViewById(R.id.comments_section)
        swishSection = findViewById(R.id.swish_section)

        // Initialize new views
        add_comment_button = findViewById(R.id.add_comment_edit_text)
        commentsList = findViewById(R.id.comments_list)
        commentsScrollView = findViewById(R.id.comments_scroll_view)
        scrollUpButton = findViewById(R.id.scroll_up_button)
        scrollDownButton = findViewById(R.id.scroll_down_button)

        // Initialize the buttons
        menuButton = findViewById(R.id.menu_toggle_button)
        reviewsButton = findViewById(R.id.reviews_toggle_button)
        commentsButton = findViewById(R.id.comments_toggle_button)
        swishButton = findViewById(R.id.swish_toggle_button)
        orderSummaryText = findViewById(R.id.order_summary_text)

        // Initialize TextViews for displaying data
        restaurantNameTextView = findViewById(R.id.restaurant_name)
        orderTypeTextView = findViewById(R.id.order_type)
        etaTextView = findViewById(R.id.eta)

        // Set click listeners to toggle visibility of respective sections
        menuButton.setOnClickListener {
            toggleSectionVisibility(menuSection)
        }

        reviewsButton.setOnClickListener {
            toggleSectionVisibility(reviewsSection)
        }

        commentsButton.setOnClickListener {
            toggleSectionVisibility(commentsSection)
        }

        swishButton.setOnClickListener {
            toggleSectionVisibility(swishSection)
        }

        // Retrieve data passed from CreateEventActivity
        val intent = intent
        val restaurantName = intent.getStringExtra("restaurant_name")
        val orderType = intent.getStringExtra("order_type")
        val eta = intent.getStringExtra("eta")
        val deadline = intent.getStringExtra("deadline")
        val restaurantRating = intent.getStringExtra("restaurant_rating")
        val foodRating = intent.getStringExtra("food_rating")


        // Display the order summary based on order type
        if (orderType == "Eat at Restaurant") {
            // No ETA displayed when eating at the restaurant
            orderSummaryText.text = "Order Type: $orderType"
        } else {
            // Display ETA for other order types
            orderSummaryText.text = "Order Type: $orderType,    ETA: $eta"
        }


        // Handle comment submission
        findViewById<Button>(R.id.add_comment_button).setOnClickListener {
            val commentText = add_comment_button.text.toString()
            if (commentText.isNotBlank()) {
                comments.add(commentText)  // Save the comment
                addCommentToList(commentText)  // Display it in the list
                add_comment_button.text.clear()  // Clear the input field
            }
        }
        // Scroll Up Button functionality
        scrollUpButton.setOnClickListener {
            commentsScrollView.smoothScrollBy(0, -200)  // Scroll up by 200 pixels
        }

        // Scroll Down Button functionality
        scrollDownButton.setOnClickListener {
            commentsScrollView.smoothScrollBy(0, 200)  // Scroll down by 200 pixels
        }
    }


        // Function to add comment to the UI
        private fun addCommentToList(comment: String) {
            val textView = TextView(this)
            textView.text = comment
            commentsList.addView(textView)  // Add the comment to the comments list layout
        }


    // Helper function to toggle visibility of a section
    private fun toggleSectionVisibility(section: View) {
        if (section.visibility == View.GONE) {
            section.visibility = View.VISIBLE
        } else {
            section.visibility = View.GONE
        }
    }
}*/
import android.content.Context
import android.content.SharedPreferences

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var scrollView: ScrollView
    private lateinit var menuSection: LinearLayout
    private lateinit var reviewsSection: LinearLayout
    private lateinit var commentsSection: LinearLayout
    private lateinit var swishSection: LinearLayout
    private lateinit var menuButton: Button
    private lateinit var reviewsButton: Button
    private lateinit var addCommentEditText: EditText
    private lateinit var commentsList: LinearLayout
    private lateinit var commentsScrollView: ScrollView
    private lateinit var scrollUpButton: Button
    private lateinit var scrollDownButton: Button
    private lateinit var commentsButton: Button
    private lateinit var swishButton: Button
    private lateinit var orderSummaryText: TextView
    // TextViews for displaying passed data
    private lateinit var restaurantNameTextView: TextView
    private lateinit var orderTypeTextView: TextView
    private lateinit var etaTextView: TextView


    private val comments = mutableListOf<String>()
    private lateinit var sharedPreferences: SharedPreferences
    private val COMMENTS_KEY = "comments_key"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        // Initialize shared preferences
        sharedPreferences = getSharedPreferences("order_summary_prefs", Context.MODE_PRIVATE)

        // Initialize the ScrollView and sections
        scrollView = findViewById(R.id.main_scroll_view)
        menuSection = findViewById(R.id.menu_section)
        reviewsSection = findViewById(R.id.reviews_section)
        commentsSection = findViewById(R.id.comments_section)
        swishSection = findViewById(R.id.swish_section)

        // Initialize new views
        addCommentEditText = findViewById(R.id.add_comment_edit_text)
        commentsList = findViewById(R.id.comments_list)
        commentsScrollView = findViewById(R.id.comments_scroll_view)
        scrollUpButton = findViewById(R.id.scroll_up_button)
        scrollDownButton = findViewById(R.id.scroll_down_button)

        // Initialize the buttons
        menuButton = findViewById(R.id.menu_toggle_button)
        reviewsButton = findViewById(R.id.reviews_toggle_button)
        commentsButton = findViewById(R.id.comments_toggle_button)
        swishButton = findViewById(R.id.swish_toggle_button)
        orderSummaryText = findViewById(R.id.order_summary_text)

        // Initialize TextViews for displaying data
        restaurantNameTextView = findViewById(R.id.restaurant_name)
        orderTypeTextView = findViewById(R.id.order_type)
        etaTextView = findViewById(R.id.eta)

        // Retrieve and display saved comments
        loadComments()

        // Set click listeners to toggle visibility of respective sections
        menuButton.setOnClickListener {
            toggleSectionVisibility(menuSection)
        }

        reviewsButton.setOnClickListener {
            toggleSectionVisibility(reviewsSection)
        }

        commentsButton.setOnClickListener {
            toggleSectionVisibility(commentsSection)
        }

        swishButton.setOnClickListener {
            toggleSectionVisibility(swishSection)
        }
        // Retrieve data passed from CreateEventActivity
        val intent = intent
        val restaurantName = intent.getStringExtra("restaurant_name")
        val orderType = intent.getStringExtra("order_type")
        val eta = intent.getStringExtra("eta")
        val deadline = intent.getStringExtra("deadline")
        val restaurantRating = intent.getStringExtra("restaurant_rating")
        val foodRating = intent.getStringExtra("food_rating")

        // Display the order summary based on order type
        if (orderType == "Eat at Restaurant") {
            // No ETA displayed when eating at the restaurant
            orderSummaryText.text = "Order Type: $orderType"
        } else {
            // Display ETA for other order types
            orderSummaryText.text = "Order Type: $orderType,    ETA: $eta"
        }

        // Handle comment submission
        findViewById<Button>(R.id.add_comment_button).setOnClickListener {
            val commentText = addCommentEditText.text.toString()
            if (commentText.isNotBlank()) {
                comments.add(commentText)  // Save the comment to the list
                addCommentToList(commentText)  // Display it in the list
                saveComments()  // Save comments to SharedPreferences
                addCommentEditText.text.clear()  // Clear the input field
            }
        }

        // Scroll Up Button functionality
        scrollUpButton.setOnClickListener {
            commentsScrollView.smoothScrollBy(0, -200)  // Scroll up by 200 pixels
        }

        // Scroll Down Button functionality
        scrollDownButton.setOnClickListener {
            commentsScrollView.smoothScrollBy(0, 200)  // Scroll down by 200 pixels
        }
    }

    // Function to add comment to the UI
    private fun addCommentToList(comment: String) {
        val textView = TextView(this)
        textView.text = comment
        commentsList.addView(textView)  // Add the comment to the comments list layout
    }

    // Save comments to SharedPreferences
    private fun saveComments() {
        val editor = sharedPreferences.edit()
        editor.putStringSet(COMMENTS_KEY, comments.toSet())  // Save comments as a Set
        editor.apply()
    }

    // Load comments from SharedPreferences and display them
    private fun loadComments() {
        val savedComments = sharedPreferences.getStringSet(COMMENTS_KEY, emptySet())  // Retrieve saved comments
        comments.clear()
        comments.addAll(savedComments!!)

        // Display each comment in the comments list
        for (comment in comments) {
            addCommentToList(comment)
        }
    }

    // Helper function to toggle visibility of a section
    private fun toggleSectionVisibility(section: View) {
        if (section.visibility == View.GONE) {
            section.visibility = View.VISIBLE
        } else {
            section.visibility = View.GONE
        }
    }
}

