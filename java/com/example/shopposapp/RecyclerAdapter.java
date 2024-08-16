package com.example.shopposapp; // Defines the package for the application

import android.view.LayoutInflater; // Imports LayoutInflater to inflate layout XML files into View objects
import android.view.View; // Imports the View class
import android.view.ViewGroup; // Imports the ViewGroup class
import android.widget.TextView; // Imports the TextView class
import androidx.annotation.NonNull; // Imports the NonNull annotation for indicating that a parameter cannot be null
import androidx.recyclerview.widget.RecyclerView; // Imports the RecyclerView class

import java.util.ArrayList; // Imports the ArrayList class for list operations

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> { // Declares the RecyclerAdapter class extending RecyclerView.Adapter
    private final ArrayList<String> receiptItems; // Declares a private final variable for storing the receipt items

    public RecyclerAdapter(ArrayList<String> receiptItems) { // Constructor for the adapter that takes an ArrayList of receipt items
        this.receiptItems = receiptItems; // Initializes the receiptItems variable with the passed ArrayList
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Called when a new ViewHolder is created
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false); // Inflates a simple list item layout
        return new ViewHolder(view); // Returns a new instance of ViewHolder with the inflated view
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // Called to bind data to the ViewHolder
        holder.textView.setText(receiptItems.get(position)); // Sets the text of the TextView in the ViewHolder to the item at the given position
    }

    @Override
    public int getItemCount() { // Returns the total number of items in the data set
        return receiptItems.size(); // Returns the size of the receiptItems list
    }

    static class ViewHolder extends RecyclerView.ViewHolder { // Declares a static ViewHolder class extending RecyclerView.ViewHolder
        TextView textView; // Declares a TextView variable

        ViewHolder(@NonNull View itemView) { // Constructor for the ViewHolder
            super(itemView); // Calls the superclass's constructor
            textView = itemView.findViewById(android.R.id.text1); // Finds the TextView in the itemView layout
        }
    }
}
