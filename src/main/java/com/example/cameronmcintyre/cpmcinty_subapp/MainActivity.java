package com.example.cameronmcintyre.cpmcinty_subapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



/**
 * Created by cameronmcintyre on 2018-02-03.
 */

public class MainActivity extends AppCompatActivity {

    private double subTotalCostValue = 0.00;
    public ListView subList;
    public SubCustomAdapter subAdapter;
    public ArrayList<Subscription> subArray = new ArrayList<Subscription>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            Subscription newSub1 = (Subscription) b.getSerializable("Subscription");
            subArray.add(newSub1);
        }




        /**
         * add item in arraylist
         */
        subArray.add(new Subscription("Netflix", 8.99));
        //subArray.add(new Subscription("Phone", 199.99));
        //subArray.add(new Subscription("Food", 200.00));




        /**
         * set item into adapter
         */
        subAdapter = new SubCustomAdapter(MainActivity.this, R.layout.row,
                subArray);
        subList = (ListView) findViewById(R.id.listView);
        subList.setItemsCanFocus(false);
        subList.setAdapter(subAdapter);


        TextView textView = (TextView) findViewById(R.id.subTotalCost);
        textView.setText("Monthly total: $"+ Double.toString(updateTotalCost()));





        /**
         * get on item click listener
         */
        // Sourced from http://www.androidhub4you.com/2013/02/muftitouch-listview-multi-click.html
        // Accessed Jan 31/18 Author: Manish Srivastava
        subList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id){
                Log.i("List View Clicked", "**********");
                Toast.makeText(MainActivity.this,
                        "List View Clicked:" + position, Toast.LENGTH_LONG)
                        .show();
                subArray.remove(position);
                subAdapter.notifyDataSetChanged();
                TextView textView = (TextView) findViewById(R.id.subTotalCost);
                textView.setText("Monthly total: $"+ Double.toString(updateTotalCost()));


            }
        });}

    /**
     * Create a new subscription
     * @param view
     */
    public void newSubscription(View view) {
            Intent intent = new Intent(this, Activity2.class);
            //intent.putExtra("subArray", subArray);
            startActivity(intent);

        }


    /**
     * Calculates the total cost of all subscriptions for a month
     * @return
     */
    private double updateTotalCost(){
            for (Subscription entry: subArray) {
                subTotalCostValue = 0.0;
                subTotalCostValue += entry.getCharge();
            }
        return subTotalCostValue;



    }

}