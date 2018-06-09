/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int numberOfCoffes = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberOfCoffes);
        String name = ((EditText) findViewById(R.id.column_edit_text_name)).getText().toString().trim();
        displayPrice(numberOfCoffes * 5, name);
        composeEmail(((TextView) findViewById(R.id.price_text_view)).getText().toString());
    }

    /**
     * This method send order in the email message
     * @param message - message
     */

    public void composeEmail(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "ORDER");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("ты хуй №" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number, String name) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.column_checkbox_toppings)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.column_checkbox_chocolate)).isChecked();
        int priceWhippedCream = hasWhippedCream ? 1 : 0;
        int priceChocolate = hasChocolate ? 1 : 0;
        priceTextView.setText(getString(R.string.user_name, name) + "\nTotal price: " + NumberFormat.getCurrencyInstance().format(number + priceWhippedCream + priceChocolate) + "\nThank you!");
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        if (numberOfCoffes < 100) {
            numberOfCoffes++;
        } else {
            Toast.makeText(this, "You have no power here!", Toast.LENGTH_SHORT).show();
            return;
        }
        display(numberOfCoffes);
    }

    public void decrement(View view) {
        if (numberOfCoffes > 1) {
            numberOfCoffes--;
        } else {
            Toast.makeText(this, "You have no power here!", Toast.LENGTH_SHORT).show();
            return;
        }
        display(numberOfCoffes);
    }
}
