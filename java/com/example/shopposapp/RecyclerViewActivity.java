package com.example.shopposapp; // Defines the package for the application

import android.app.Activity; // Imports the Activity class from the Android framework
import android.os.Bundle; // Imports the Bundle class for saving instance state
import androidx.recyclerview.widget.LinearLayoutManager; // Imports the LinearLayoutManager for RecyclerView
import androidx.recyclerview.widget.RecyclerView; // Imports the RecyclerView class

import java.util.ArrayList; // Imports the ArrayList class for list operations
import java.util.Arrays; // Imports the Arrays utility class

public class RecyclerViewActivity extends Activity { // Declares the RecyclerViewActivity class as a subclass of Activity
    @Override // Indicates that the following method overrides a method in the superclass
    protected void onCreate(Bundle savedInstanceState) { // The onCreate method is called when the activity is first created
        super.onCreate(savedInstanceState); // Calls the superclass's onCreate method to perform default initialization
        setContentView(R.layout.activity_recyclerview); // Sets the user interface layout for this Activity

        RecyclerView recyclerView = findViewById(R.id.recyclerView); // Finds the RecyclerView in the layout by its ID
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Sets a LinearLayoutManager to the RecyclerView for vertical list orientation

        String[] receiptArray = getIntent().getStringArrayExtra("receipt"); // Retrieves a string array passed with the intent under the key "receipt"
        ArrayList<String> receiptItems = new ArrayList<>(Arrays.asList(receiptArray)); // Converts the string array to an ArrayList
        RecyclerAdapter adapter = new RecyclerAdapter(receiptItems); // Creates an adapter with the list of receipt items
        recyclerView.setAdapter(adapter); // Sets the adapter to the RecyclerView to display the data
    }
}
