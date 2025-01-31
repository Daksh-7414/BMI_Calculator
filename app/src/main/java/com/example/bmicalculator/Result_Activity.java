package com.example.bmicalculator;

import static com.example.bmicalculator.R.string.result_string_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent f2 =getIntent();
        float bmi= f2.getFloatExtra("Result",0);

        TextView bmi_result = findViewById(R.id.textView2);
        TextView bmi_result_string = findViewById(R.id.result_string);

        if (bmi>=-18.5 && bmi<18.5){
            bmi_result.setTextColor(getResources().getColor(R.color.blue));
            bmi_result_string.setText(getString(R.string.result_string_1)+" "+bmi+getString(R.string.result_string_2)+" Under Weight "+getString(R.string.result_string_3));
        } else if (bmi>=18.5 &&bmi<24.9) {
            bmi_result.setTextColor(getResources().getColor(R.color.green));
            bmi_result_string.setText(getString(R.string.result_string_1)+" "+bmi+getString(R.string.result_string_2)+" Normal Weight "+getString(R.string.result_string_3));
        }else {
            bmi_result.setTextColor(getResources().getColor(R.color.red));
            bmi_result_string.setText(getString(R.string.result_string_1)+" "+bmi+getString(R.string.result_string_2)+" Overweight "+getString(R.string.result_string_3));
        }

        bmi_result.setText(String.valueOf(bmi));

//      recalculate button code
        Button b1 = findViewById(R.id.reCalculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iBack = new Intent(Result_Activity.this, MainActivity.class);
                startActivity(iBack);
                finish();
            }
        });
    }
}