/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText("0");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameText = (EditText) findViewById(R.id.name_text);
        CheckBox hasWhippedCreamChecked = (CheckBox) findViewById(R.id.checkbox_whippedcream);
        CheckBox hasChocolateChecked = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasWhippedCream = hasWhippedCreamChecked.isChecked();
        boolean hasChocolate = hasChocolateChecked.isChecked();
        String name = nameText.getText().toString();
        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage =  createOrderSummary(price,hasWhippedCream,hasChocolate,name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private int calculatePrice(boolean whippedCreamTopping, boolean chocolateTopping) {
        int basePrice = 5;

        if(whippedCreamTopping) {
            basePrice = basePrice + 1;
        }

        if(chocolateTopping) {
            basePrice = basePrice + 2;
        }

        return basePrice * quantity;
    }
    private String createOrderSummary(int price, boolean checkState, boolean checkState1, String customer) {
        String name ="\nCustomer : " + customer;
        String whippedCream = "\nAdded whipped cream? : " + checkState;
        String chocolate = "\nAdded chocolate? : " + checkState1;
        //Log.v("MainActivity", "Added whipped cream : " + checkState);
        String priceMessage = name + whippedCream + chocolate + "\nQuantity : " + quantity + "\nTotal = $" + price ;
        priceMessage = priceMessage + "\nThank You!";
        //displayMessage(priceMessage);
        return priceMessage;
    }


    public void increment(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Quantity is too high";
        int duration = Toast.LENGTH_SHORT;

        if(quantity < 100) {
           quantity = quantity + 1;
           displayQuantity(quantity);
       }
       else {

           Toast toast = Toast.makeText(context, text, duration);
           toast.show();
       }

    }

    public void decrement(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Quantity is too low";
        int duration = Toast.LENGTH_SHORT;
        if(quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
        else{

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int someNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + someNumber);
    }

 /*   private boolean hasWhippedCream(View view) {
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_whippedcream);
        boolean checkState = checkbox.isChecked();
        if(checkState) {
           Log.v("MainActivity", "When it is checked : " + checkState);
        }
        else {
            Log.v("MainActivity", "When it is not checked : " + checkState);

        }
    }
*/
    /**
     * This method displays the given text on the screen.
     */
   /* private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }*/

}