package com.example.aileen.coffeeconstraint;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private Button button;
    private Spinner crowdSpinner;
    private CoffeeShop myCoffeeShop = new CoffeeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get spinner
        crowdSpinner = findViewById(R.id.spinner);
        //get button
        button = findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findCoffee(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);
    }

    private void findCoffee(View view){
        //get spinner item array position
        Integer crowd = crowdSpinner.getSelectedItemPosition();
        //set the coffee shop
        myCoffeeShop.setCoffeeShop(crowd);
        //get suggested coffee shop
        String suggestedCoffeeShop = myCoffeeShop.getCoffeeShop();
        //get URL of suggested coffee shop
        String suggestedCoffeeShopURL = myCoffeeShop.getCoffeeShopURL();
        Log.i("shop suggested", suggestedCoffeeShop);
        Log.i("url suggested", suggestedCoffeeShopURL);

        //create an Intent
        Intent intent = new Intent(this, ReceiveCoffeeActivity.class);

        //pass data
        intent.putExtra("coffeeShopName", suggestedCoffeeShop);
        intent.putExtra("coffeeShopURL", suggestedCoffeeShopURL);

        //start intent
        startActivity(intent);
    }
}
