package com.sadataljony.app.android.demo.passdatabetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnGoToActivityA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // get values from ActivityA
        Intent intent = getIntent();
        String myStringFromActivityA = intent.getStringExtra("my_string");// get string value
        int myIntegerFromActivityA = intent.getIntExtra("my_integer", 0);// get integer value
        double myDoubleFromActivityA = intent.getDoubleExtra("my_double", 0.0);// get double value

        // initialize views
        EditText mEditTextString = findViewById(R.id.editTextActivityBString);
        EditText mEditTextInteger = findViewById(R.id.editTextActivityBInteger);
        EditText mEditTextDouble = findViewById(R.id.editTextActivityBDouble);

        mEditTextString.setText(myStringFromActivityA);//set string to EditText
        mEditTextInteger.setText(String.valueOf(myIntegerFromActivityA));// set integer to EditText
        mEditTextDouble.setText(String.valueOf(myDoubleFromActivityA));// set double to EditText

        mBtnGoToActivityA = findViewById(R.id.btnActivityBGoToActivityA);
        mBtnGoToActivityA.setOnClickListener(this);// set onClick event in Button
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnGoToActivityA) {
            finish();
            startActivity(new Intent(ActivityB.this, ActivityA.class));
        }

    }
}
