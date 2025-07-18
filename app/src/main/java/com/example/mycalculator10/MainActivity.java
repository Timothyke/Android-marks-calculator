package com.example.mycalculator10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button btnAdd, btnMultiply;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // This links to your XML layout

        // Initialize UI elements
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        btnAdd = findViewById(R.id.btnAdd);
        btnMultiply = findViewById(R.id.btnMultiply);
        resultText = findViewById(R.id.resultText);

        // Handle Add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("add");
            }
        });

        // Handle Multiply button
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("multiply");
            }
        });
    }

    private void calculate(String operation) {
        String val1 = input1.getText().toString();
        String val2 = input2.getText().toString();

        if (val1.isEmpty() || val2.isEmpty()) {
            resultText.setText("Please enter both numbers");
            return;
        }

        try {
            double num1 = Double.parseDouble(val1);
            double num2 = Double.parseDouble(val2);
            double result;

            if (operation.equals("add")) {
                result = num1 + num2;
            } else {
                result = num1 * num2;
            }

            resultText.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultText.setText("Invalid input");
        }
    }
}
