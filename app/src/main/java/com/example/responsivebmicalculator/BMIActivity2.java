package com.example.responsivebmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity2 extends AppCompatActivity {
    android.widget.Button recalculateBMI;
    TextView BMI, GenderCategory, BMICategory;
    ImageView imageView;
    RelativeLayout setBackground;
    String mBMI;
    float resBMI;


    String height, weight;
    float intHeight, intWeight;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity2);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Result");

//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("1E1D1D"));
//        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        recalculateBMI = findViewById(R.id.RecalculateBMI);
        BMI =findViewById(R.id.BMI);
        GenderCategory = findViewById(R.id.GenderCategory);
        BMICategory = findViewById(R.id.BMICategory);
        imageView = findViewById(R.id.Imageview);
        setBackground = findViewById(R.id.ContentLayout);
        Intent intent;
//        getSupportActionBar().setElevation(0);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color =\"white\"</font> "));


        intent = getIntent();

        height = intent.getStringExtra("Height");
        weight = intent.getStringExtra("Weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100; // it converts height in cm to meter.
        resBMI = intWeight/(intHeight*intHeight);
        mBMI = Float.toString(resBMI);

        if (resBMI < 18.5){
            BMICategory.setText("UnderWeight Person");
            setBackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.croos);
        }
        else if (resBMI > 18.5 && resBMI <= 24.9){
            BMICategory.setText("Healthy Person");
//            setBackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.ok);
        }
        else if (resBMI > 25.0 && resBMI <= 29.9){
            BMICategory.setText("OverWeight Person");
            setBackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if (resBMI > 30.0 && resBMI < 34.9){
            BMICategory.setText("Obese Class 1 Person");
            setBackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else {
            BMICategory.setText("Much Obese Person");
            setBackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }

        GenderCategory.setText(intent.getStringExtra("Gender"));
        BMI.setText(mBMI);

        recalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}