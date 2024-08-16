package com.example.shopposapp; // Defines the package for the application

import android.os.Bundle; // Imports the Bundle class for saving instance state
import android.widget.ArrayAdapter; // Imports the ArrayAdapter class for managing a collection of data
import android.widget.ListView; // Imports the ListView class for displaying a list of items
import androidx.appcompat.app.AppCompatActivity; // Imports the AppCompatActivity class for compatibility support

public class ListViewActivity extends AppCompatActivity { // Declares the ListViewActivity class as a subclass of AppCompatActivity

    private ListView listView; // Declares a private ListView variable
    private String[] receipt; // Declares a private String array for receipt items

    @Override // Indicates that the following method overrides a method in the superclass
    protected void onCreate(Bundle savedInstanceState) { // The onCreate method is called when the activity is first created
        super.onCreate(savedInstanceState); // Calls the superclass's onCreate method to perform default initialization
        setContentView(R.layout.activity_list_view); // Sets the user interface layout for this Activity

        listView = findViewById(R.id.listView); // Finds the ListView in the layout by its ID

        receipt = getIntent().getStringArrayExtra("receipt"); // Retrieves a string array passed with the intent under the key "receipt"
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, receipt); // Creates an ArrayAdapter with the receipt items
        listView.setAdapter(adapter); // Sets the adapter to the ListView to display the data
    }
}
