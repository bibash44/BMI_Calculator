package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cal_bmi;
    TextView result;
    EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal_bmi= findViewById(R.id.btn_cal_bmi);
        result= findViewById(R.id.txt_result);
        height= findViewById(R.id.txt_height);
        weight=findViewById(R.id.txt_weight);

        cal_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height_in_meter= Double.parseDouble(height.getText().toString())*0.01;
                Double weight_in_kg= Double.parseDouble(weight.getText().toString());

                Double height_in_meter_square= height_in_meter*height_in_meter;

                /*calculating BMI*/
                Double BMI= weight_in_kg/height_in_meter_square;

                result.setText(result.getText()+BMI.toString());

                /*condition for under weight*/
                if(BMI<18.5){
                    Toast.makeText(MainActivity.this, "You are under weight", Toast.LENGTH_LONG).show();
                }

                /*condition for normal weight*/
                if(BMI>=18.5 && BMI<24.9){
                    Toast.makeText(MainActivity.this, "Your weight is normal", Toast.LENGTH_LONG).show();
                }


                /*condition for over weight*/
                if(BMI>=25 && BMI<29.9){
                    Toast.makeText(MainActivity.this, "You are over weight", Toast.LENGTH_LONG).show();
                }

                /*condition for obesity weight*/
                if(BMI>=30){
                    Toast.makeText(MainActivity.this, "Your weight is obesity", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
