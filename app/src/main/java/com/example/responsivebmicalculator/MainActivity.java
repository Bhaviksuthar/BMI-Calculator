package com.example.responsivebmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.widget.Button calculateBMI;

    TextView cHeight, cWeight, cAge;
    ImageView WIncrement, WDecrement, AgeIncrement, AgeDecrement;
    RelativeLayout male, female;
    SeekBar seekBar;

    int intWeight = 55;
    int intAge = 22;
    int currentProgress;
    String mintProgress = "150";
    String typeofUser = "0";
    String weight2 = "50";
    String age2 = "22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculateBMI = findViewById(R.id.calculateBMI);
        cHeight = findViewById(R.id.Height);
        cWeight = findViewById(R.id.Weight);
        cAge = findViewById(R.id.Age);
        WDecrement = findViewById(R.id.weightDecrement);
        WIncrement = findViewById(R.id.weightIncrement);
        AgeIncrement = findViewById(R.id.ageIncrement);
        AgeDecrement = findViewById(R.id.ageDecrement);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        seekBar = findViewById(R.id.seekBar);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setBackground() method for setting background of our layout or views
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofUser = "Female";
            }
        });

        seekBar.setMax(300);
        seekBar.setProgress(150);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mintProgress = String.valueOf(currentProgress);
                cHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AgeIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge +1;
                age2 = String.valueOf(intAge);
                cAge.setText(age2);
            }
        });

        AgeDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge -1;
                age2 = String.valueOf(intAge);
                cAge.setText(age2);
            }
        });

        WIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight +1;
                weight2 = String.valueOf(intWeight);
                cWeight.setText(weight2);
            }
        });

        WDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight -1;
                weight2 = String.valueOf(intWeight);
                cWeight.setText(weight2);
            }
        });


        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (typeofUser.equals("0")) {
                        Toast.makeText(MainActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                    } else if (mintProgress.equals("0")) {
                        Toast.makeText(MainActivity.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                    } else if (intAge == 0 || intAge < 0) {
                        Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                    } else if (intWeight == 0 || intWeight < 0) {
                        Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent intent = new Intent(MainActivity.this, BMIActivity2.class);
                        intent.putExtra("Gender", typeofUser);
                        intent.putExtra("Height", mintProgress);
                        intent.putExtra("Weight", weight2);
                        intent.putExtra("Age", age2);
                        startActivity(intent);
                        finish();
                    }
                }
                catch (Exception e){

                }
            }
        });
    }
}