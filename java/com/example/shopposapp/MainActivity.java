package com.example.shopposapp; // Defines the package for the application

import android.content.Intent; // Imports the Intent class for starting new activities
import android.os.Bundle; // Imports the Bundle class for saving instance state
import android.view.View; // Imports the View class for handling UI components
import android.widget.Button; // Imports the Button class for button UI components
import android.widget.EditText; // Imports the EditText class for text input UI components
import androidx.appcompat.app.AppCompatActivity; // Imports the AppCompatActivity class for compatibility support

public class MainActivity extends AppCompatActivity { // Declares the MainActivity class as a subclass of AppCompatActivity

    // Declare private EditText fields for input and output
    private EditText etBreadPrice, etBreadQuantity, etBreadTotal;
    private EditText etPenPrice, etPenQuantity, etPenTotal;
    private EditText etWatchPrice, etWatchQuantity, etWatchTotal;
    private EditText etMilkPrice, etMilkQuantity, etMilkTotal;
    private EditText etGrandTotal, etDiscount, etNetPay;

    // Declare private Button fields for actions
    private Button btnCalculate, btnStringBuffer, btnListView, btnRecyclerView;

    @Override // Indicates that the following method overrides a method in the superclass
    protected void onCreate(Bundle savedInstanceState) { // The onCreate method is called when the activity is first created
        super.onCreate(savedInstanceState); // Calls the superclass's onCreate method to perform default initialization
        setContentView(R.layout.activity_main); // Sets the user interface layout for this Activity

        // Initialize EditText views by finding them by their ID
        etBreadPrice = findViewById(R.id.etBreadPrice);
        etBreadQuantity = findViewById(R.id.etBreadQuantity);
        etBreadTotal = findViewById(R.id.etBreadTotal);

        etPenPrice = findViewById(R.id.etPenPrice);
        etPenQuantity = findViewById(R.id.etPenQuantity);
        etPenTotal = findViewById(R.id.etPenTotal);

        etWatchPrice = findViewById(R.id.etWatchPrice);
        etWatchQuantity = findViewById(R.id.etWatchQuantity);
        etWatchTotal = findViewById(R.id.etWatchTotal);

        etMilkPrice = findViewById(R.id.etMilkPrice);
        etMilkQuantity = findViewById(R.id.etMilkQuantity);
        etMilkTotal = findViewById(R.id.etMilkTotal);

        etGrandTotal = findViewById(R.id.etGrandTotal);
        etDiscount = findViewById(R.id.etDiscount);
        etNetPay = findViewById(R.id.etNetPay);

        // Initialize Button views by finding them by their ID
        btnCalculate = findViewById(R.id.btnCalculate);
        btnStringBuffer = findViewById(R.id.btnStringBuffer);
        btnListView = findViewById(R.id.btnListView);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);

        // Set onClickListener for the Calculate button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Method to handle click event
                calculateTotals(); // Calls the method to calculate totals
            }
        });

        // Set onClickListener for the StringBuffer button
        btnStringBuffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Method to handle click event
                Intent intent = new Intent(MainActivity.this, StringBufferActivity.class); // Creates an intent to start StringBufferActivity
                intent.putExtra("receipt", generateReceipt()); // Adds receipt data to the intent
                startActivity(intent); // Starts the activity
            }
        });

        // Set onClickListener for the ListView button
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Method to handle click event
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class); // Creates an intent to start ListViewActivity
                intent.putExtra("receipt", generateReceipt()); // Adds receipt data to the intent
                startActivity(intent); // Starts the activity
            }
        });

        // Set onClickListener for the RecyclerView button
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Method to handle click event
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class); // Creates an intent to start RecyclerViewActivity
                intent.putExtra("receipt", generateReceipt()); // Adds receipt data to the intent
                startActivity(intent); // Starts the activity
            }
        });
    }

    // Method to calculate totals for each item and overall totals
    private void calculateTotals() {
        double breadTotal = calculateItemTotal(etBreadPrice, etBreadQuantity); // Calculates the total for bread
        double penTotal = calculateItemTotal(etPenPrice, etPenQuantity); // Calculates the total for pens
        double watchTotal = calculateItemTotal(etWatchPrice, etWatchQuantity); // Calculates the total for watches
        double milkTotal = calculateItemTotal(etMilkPrice, etMilkQuantity); // Calculates the total for milk

        // Set the calculated totals to their respective EditText fields
        etBreadTotal.setText(String.valueOf(breadTotal));
        etPenTotal.setText(String.valueOf(penTotal));
        etWatchTotal.setText(String.valueOf(watchTotal));
        etMilkTotal.setText(String.valueOf(milkTotal));

        // Calculate and set the grand total
        double grandTotal = breadTotal + penTotal + watchTotal + milkTotal;
        etGrandTotal.setText(String.valueOf(grandTotal));

        // Calculate and set the discount (15% of the grand total)
        double discount = grandTotal * 0.15;
        etDiscount.setText(String.valueOf(discount));

        // Calculate and set the net pay after discount
        double netPay = grandTotal - discount;
        etNetPay.setText(String.valueOf(netPay));
    }

    // Method to calculate the total price for an item based on price and quantity
    private double calculateItemTotal(EditText priceField, EditText quantityField) {
        double price = Double.parseDouble(priceField.getText().toString()); // Parses the price from EditText
        int quantity = Integer.parseInt(quantityField.getText().toString()); // Parses the quantity from EditText
        return price * quantity; // Returns the total price
    }

    // Method to generate a receipt as a string array
    private String[] generateReceipt() {
        return new String[]{
                "Item: Bread, Price: " + etBreadPrice.getText().toString() + ", Quantity: " + etBreadQuantity.getText().toString() + ", Total: " + etBreadTotal.getText().toString(),
                "Item: Pen, Price: " + etPenPrice.getText().toString() + ", Quantity: " + etPenQuantity.getText().toString() + ", Total: " + etPenTotal.getText().toString(),
                "Item: Watch, Price: " + etWatchPrice.getText().toString() + ", Quantity: " + etWatchQuantity.getText().toString() + ", Total: " + etWatchTotal.getText().toString(),
                "Item: Milk, Price: " + etMilkPrice.getText().toString() + ", Quantity: " + etMilkQuantity.getText().toString() + ", Total: " + etMilkTotal.getText().toString(),
                "Grand Total: " + etGrandTotal.getText().toString(),
                "Discount: " + etDiscount.getText().toString(),
                "Net Pay: " + etNetPay.getText().toString()
        };
    }
}
