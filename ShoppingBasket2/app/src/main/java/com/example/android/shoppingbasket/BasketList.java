package com.example.android.shoppingbasket;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

import static android.R.id.list;
import static android.os.Build.VERSION_CODES.M;
import static com.example.android.shoppingbasket.R.id.searchArea;

public class BasketList extends AppCompatActivity {

    private int cost;
    private TextView moneyView;
    private EditText search;
    private Button scanBTN;
    private Button submitBTN;
    private ListView listView;
    private  LinearLayout mainLayout;
    ArrayAdapter<Item> listViewAdapter;
    private static AdapterItem adapter;
    ArrayList<Item> listItems = new ArrayList<>();
    static final String COST = "items_cost";
    static final String MONEY_VIEW = "money_view";
    static final String SEARCH = "search_text";
    static final String LISTITEMS = "listarray";

    private CheckBox chcBox;
    private Button settingsBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_list);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            listItems = (ArrayList<Item>) i.getSerializableExtra("sampleObject");
        }

        moneyView = (TextView)findViewById(R.id.moneyTxt);
        search = (EditText)findViewById(R.id.itemSearch);
        search.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            search.setText("");

                                        }
                                    });
        scanBTN = (Button)findViewById(R.id.barcodeScn);
        scanBTN.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent toNewItem = new Intent(BasketList.this, newItem.class);
                                          startActivity(toNewItem);
                                      }
                                  });
        submitBTN = (Button)findViewById(R.id.submit);
        submitBTN.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Item temp = new Item();
                                           temp.Item(search.getText().toString());
                                           listItems.add(temp);
                                           moneyView.requestFocus();
                                           InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                           imm.hideSoftInputFromWindow(search.getWindowToken(), 0);
                                           search.getText().clear();
                                       }
                                     });

        listView = (ListView) findViewById(R.id.shoppingList);
//        listViewAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                listItems);
//        listView.setAdapter(listViewAdapter);

        adapter = new AdapterItem(listItems,getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Item Items = listItems.get(position);
                settingsBTN = (Button)findViewById(R.id.settings);
                settingsBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toSettings = new Intent(BasketList.this, settings.class);
//                        toSettings.putExtra("sampleObject",listItems);
                        startActivity(toSettings);
                    }
                });
            }
        });
    }
//
//    /**
//     * Functions to save and restore the current state
//     */
//    @Override
//    public void onSaveInstanceState (Bundle savedInstanceState) {
//        savedInstanceState.putFloat(COST,cost);
//        savedInstanceState.putSerializable(LISTITEMS, listItems);
//
//
//        super.onSaveInstanceState(savedInstanceState);
//    }
//
//    @Override
//    public void onRestoreInstanceState (Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//        cost = savedInstanceState.getInt(COST);
//        listItems = (ArrayList<Item>) savedInstanceState.getSerializable(LISTITEMS);
//
//    }

}
