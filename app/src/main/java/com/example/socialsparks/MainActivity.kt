
package com.example.socialsparks

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestionText = findViewById<TextView>(R.id.suggestionText)
        val getSuggestionButton =
            findViewById<Button>(R.id.getSuggestionButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Get a social suggestion when the button is clicked
        getSuggestionButton.setOnClickListener {

            val time = timeInput.text.toString().trim().lowercase()

            // Check if the user entered something
            if (time.isEmpty()) {
                suggestionText.text =
                    "Please enter a time of day."
                Log.w("SocialSparks", "Empty time input")

            } else {

                // Use if statements to select a suggestion
                if (time == "morning") {
                    suggestionText.text =
                        "Send a Good morning message to a family member."

                } else if (time == "mid-morning" ||
                    time == "mid morning") {
                    suggestionText.text =
                        "Reach out to a colleague with a quick thank-you."

                } else if (time == "afternoon") {
                    suggestionText.text =
                        "Share a funny meme or interesting link with a friend."

                } else if (time == "afternoon snack time" ||
                    time == "snack time") {
                    suggestionText.text =
                        "Send a quick thinking-of-you message."

                } else if (time == "dinner") {
                    suggestionText.text =
                        "Call a friend or relative for a 5-minute catch-up."

                } else if (time == "after dinner" ||
                    time == "night" ||
                    time == "after dinner / night") {
                    suggestionText.text =
                        "Leave a thoughtful comment on a friend's post."

                } else {
                    suggestionText.text =
                        "Invalid time. Try Morning, Mid-morning, Afternoon, Afternoon Snack Time, Dinner or Night."

                    Log.w("SocialSparks", "Invalid input: $time")
                }
            }
        }

        // Reset the input and suggestion
        resetButton.setOnClickListener {
            timeInput.text.clear()
            suggestionText.text = "Your social suggestion will appear here."
            Log.d("SocialSparks", "App has been reset")
        }
    }
}
