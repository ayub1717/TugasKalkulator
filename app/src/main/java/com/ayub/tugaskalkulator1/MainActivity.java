package com.ayub.tugaskalkulator1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.angka1);
        editText2 = findViewById(R.id.angka2);
        buttonAdd = findViewById(R.id.plus);
        buttonSubtract = findViewById(R.id.min);
        buttonMultiply = findViewById(R.id.times);
        buttonDivide = findViewById(R.id.devide);
        textViewResult = findViewById(R.id.outputHasil);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+'); // Memanggil metode calculate dengan operator +
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-'); // Memanggil metode calculate dengan operator -
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*'); // Memanggil metode calculate dengan operator *
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/'); // Memanggil metode calculate dengan operator /
            }
        });
    }

    private void calculate(char operator) {
        double operand1 = Double.parseDouble(editText1.getText().toString());
        double operand2 = Double.parseDouble(editText2.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    textViewResult.setText("Tidak dapat membagi dengan nol");
                    return;
                }
                break;
        }

        textViewResult.setText("Hasil: " + result);
    }
}
