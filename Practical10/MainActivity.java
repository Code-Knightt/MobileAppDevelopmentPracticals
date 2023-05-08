package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView sign, result;
    Button add, subtract, multiply, divide, equal;
    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        add = (Button) findViewById(R.id.add_button);
        subtract = (Button) findViewById(R.id.subtract_button);
        multiply = (Button) findViewById(R.id.multiply_button);
        divide = (Button) findViewById(R.id.divide_button);
        equal = (Button) findViewById(R.id.equal_button);

        num1 = (EditText) findViewById(R.id.number_1);
        num2 = (EditText) findViewById(R.id.number_2);

        sign = (TextView) findViewById(R.id.sign);
        result = (TextView) findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign.setText("+");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign.setText("-");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign.setText("/");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign.setText("x");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(num1.getText().toString());
                    int second = Integer.parseInt(num2.getText().toString());
                    Float res;

                    String signChar = sign.getText().toString();

                    switch (signChar) {
                        case "+":
                            res = (float) (first + second);
                            break;
                        case "-":
                            res = (float) (first - second);
                            break;
                        case "x":
                            res = (float) (first * second);
                            break;
                        case "/":
                            res = (float) (first / second);
                            break;
                        default:
                            throw new Exception("Something went wrong");
                    }

                    result.setText(res.toString());
                } catch (Exception e){
                    result.setText("err");
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}