package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.String;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox WhippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_checkbox);
        boolean hasWhippedCream =  WhippedCreamCheckBox.isChecked();
        CheckBox Chocolate = (CheckBox)findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate  = Chocolate.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);

          String priceMessage = createOrderSummary(name,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);

    }

    private int calculatePrice(boolean addWhippedCream,boolean addchocolate){
        int basePrice = 10;
        if(addWhippedCream)
        {
            basePrice = basePrice + 2;
        }
        if(addchocolate)
        {
            basePrice = basePrice + 4;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String name,int price , boolean addWhippedCream,boolean addchocolate){
        String priceMessage = "Name of Customer =  " + name ;
        priceMessage  +=   "\nQuantity =  "+ quantity +  " cups of coffee" ;
        priceMessage += "\nAdd Whipped Cream =  " + addWhippedCream;
        priceMessage += "\nAdd Chocolate  =  " + addchocolate;
        priceMessage += "\nTotal Rs  " + price;
        priceMessage += "\nThank you and Visit Again!!!";

         return priceMessage;

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view ){

        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view ){
        if(quantity >= 1) {
            quantity = quantity - 1;
            display(quantity);
        }else
        {
            quantity = 1;
        }

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}