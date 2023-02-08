package com.example.practical02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText first,second;
    TextView result;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first = (EditText) findViewById(R.id.text1);
        second = (EditText) findViewById(R.id.text2);
        result = (TextView) findViewById(R.id.result);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String string1 = first.getText().toString();
                String string2 = second.getText().toString();
                String concat = string1.concat(string2);
                result.setText(concat);
            }
        });
    }
}