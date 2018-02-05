package com.example.cameronmcintyre.cpmcinty_subapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity2 extends AppCompatActivity {

    private EditText nameText;
    private EditText chargeText;
    private EditText dateText;
    private EditText commentM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nameText = (EditText) findViewById(R.id.subName1);
        chargeText = (EditText) findViewById(R.id.charge1);
        dateText = (EditText) findViewById(R.id.dateText);
        commentM = (EditText) findViewById(R.id.comment1);}



        public void cancelSubscription(View view) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
        public void addSubscription(View view) {

            setResult(RESULT_OK);
            String name = nameText.getText().toString();
            double charge = Double.parseDouble(chargeText.getText().toString());
            String comment = commentM.getText().toString();
            Subscription newSub = new Subscription(name, charge, comment);



            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Subscription", newSub);

            startActivity(intent);
        }






    }

