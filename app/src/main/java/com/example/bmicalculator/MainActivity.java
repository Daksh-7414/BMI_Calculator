package com.example.bmicalculator;

import static java.lang.String.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1 = findViewById(R.id.weightInput);
        EditText e2 = findViewById(R.id.heightFt);
        EditText e3 = findViewById(R.id.heightIn);
        Button b1 = findViewById(R.id.calButton);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().trim().isEmpty() || e2.getText().toString().trim().isEmpty() || e3.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                }else {
                    int weight = Integer.parseInt(e1.getText().toString().trim());
                    int heightFt = Integer.parseInt(e2.getText().toString().trim());
                    int heightIn = Integer.parseInt(e3.getText().toString().trim());
                    float bmi;

                    if (weight == 0 || heightFt==0) {
                        Toast.makeText(MainActivity.this, "Enter Valid value", Toast.LENGTH_SHORT).show();
                    } else {
                        heightFt *= 12;
                        float heightM = (float) ((heightFt + heightIn) * 0.0254);
                        bmi = weight / (heightM * heightM);

                        bmi = Float.parseFloat(format("%.1f", bmi));

                        Intent I1 = new Intent(MainActivity.this, Result_Activity.class);
                        I1.putExtra("Result", bmi);
                        startActivity(I1);
                        finish();
                    }
                }
            }
        });
    }
}