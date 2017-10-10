package com.example.android.shoppingbasket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        If we call an activity with an intent and we want to get the data out from it use the following code:
//        Intent i = getIntent();
//        Bundle extras = getIntent().getExtras();
//

    }
    //        Redirecting to the correct activity on taping a button
    public void onButtonClick(View view) {
//        if(view.getId() == R.id.newItemBTN) {
//            Intent toNewItem = new Intent(MainActivity.this, newItem.class);
//            startActivity(toNewItem);
//        }
        if(view.getId() == R.id.basketBTN) {
            Intent toBasketList = new Intent(MainActivity.this, BasketList.class);
            startActivity(toBasketList);
        }
    }
}