package com.example.practical04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button itou, utoi;
    EditText inr, usd;
    Double rupees = 0.0, dollars = 0.0;
    Double conversionRate = 82.65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itou = (Button) findViewById(R.id.i2u);
        utoi = (Button) findViewById(R.id.u2i);

        inr = (EditText) findViewById(R.id.inrAmount);
        usd = (EditText) findViewById(R.id.usdAmount);

        itou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(inr.getText())){
                    Toast.makeText(getApplicationContext(), "Rupees Field is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                rupees = Double.parseDouble(inr.getText().toString());
                dollars = rupees / conversionRate;
                usd.setText(String.format(Locale.US,"%.4f", dollars));
            }
        });

        utoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(usd.getText())){
                    Toast.makeText(getApplicationContext(), "Dollars Field is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                dollars = Double.parseDouble(usd.getText().toString());
                rupees = dollars * conversionRate;
                inr.setText(String.format(Locale.UK, "%.2f", rupees));
            }
        });
    }
}