package com.example.practical07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(username.getText())){
                    Toast.makeText(getApplicationContext(),"Username is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password.getText())){
                    Toast.makeText(getApplicationContext(),"Password is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                String name = username.getText().toString();
                String pass = password.getText().toString();

                if(!pass.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")){
                    Toast.makeText(getApplicationContext(),"Password should be at least 8 characters long\n contain at least one letter and one number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent greet = new Intent(MainActivity.this, GreetActivity.class);
                Bundle data = new Bundle();
                data.putString("username", name);
                greet.putExtras(data);

                startActivity(greet);
            }
        });

    }
}