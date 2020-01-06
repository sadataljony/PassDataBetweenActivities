package com.sadataljony.app.android.demo.passdatabetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class ActivityA extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditTextString, mEditTextInteger, mEditTextDouble;
    private Button mBtnPassDataToAnotherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        //initialize views
        mEditTextString = findViewById(R.id.editTextString);
        mEditTextInteger = findViewById(R.id.editTextInteger);
        mEditTextDouble = findViewById(R.id.editTextDouble);
        mBtnPassDataToAnotherActivity = findViewById(R.id.btnPassDataToAnotherActivity);
        mBtnPassDataToAnotherActivity.setOnClickListener(this);// set onClick event in Button
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnPassDataToAnotherActivity) {
            if (mEditTextString.getText().toString().trim().equalsIgnoreCase("")) {
                mEditTextString.setError("This field can not be blank");
            } else if (mEditTextInteger.getText().toString().trim().equalsIgnoreCase("")) {
                mEditTextString.setError("This field can not be blank");
            } else if (mEditTextDouble.getText().toString().trim().equalsIgnoreCase("")) {
                mEditTextString.setError("This field can not be blank");
            } else {
                String myString = mEditTextString.getText().toString();
                int myInteger = Integer.parseInt(mEditTextInteger.getText().toString());
                double myDouble = Double.parseDouble(mEditTextDouble.getText().toString());

                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("my_string", myString);// set String to my_string key
                intent.putExtra("my_integer", myInteger);// set Integer to my_integer key
                intent.putExtra("my_double", myDouble);// set Double to my_double key
                startActivity(intent);
            }
        }
    }
}
