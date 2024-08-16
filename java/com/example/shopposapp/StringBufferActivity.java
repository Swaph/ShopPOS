package com.example.shopposapp; // Defines the package for the application

import android.os.Bundle; // Imports the Bundle class for saving instance state
import android.widget.TextView; // Imports the TextView class for displaying text
import androidx.appcompat.app.AppCompatActivity; // Imports the AppCompatActivity class for compatibility support

public class StringBufferActivity extends AppCompatActivity { // Declares the StringBufferActivity class as a subclass of AppCompatActivity

    private TextView textView; // Declares a private TextView variable
    private String[] receipt; // Declares a private String array for receipt items

    @Override // Indicates that the following method overrides a method in the superclass
    protected void onCreate(Bundle savedInstanceState) { // The onCreate method is called when the activity is first created
        super.onCreate(savedInstanceState); // Calls the superclass's onCreate method to perform default initialization
        setContentView(R.layout.activity_string_buffer); // Sets the user interface layout for this Activity

        textView = findViewById(R.id.textView); // Finds the TextView in the layout by its ID

        receipt = getIntent().getStringArrayExtra("receipt"); // Retrieves a string array passed with the intent under the key "receipt"
        StringBuffer stringBuffer = new StringBuffer(); // Creates a new StringBuffer to concatenate receipt items

        
        for (String line : receipt) { // Iterates over each string in the receipt array
            stringBuffer.append(line).append("\n"); // Appends each string followed by a newline character to the StringBuffer
        }

        textView.setText(stringBuffer.toString()); // Sets the concatenated string as the text of the TextView
    }
}
