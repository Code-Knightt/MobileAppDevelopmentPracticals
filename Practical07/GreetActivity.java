package com.example.practical07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetActivity extends AppCompatActivity {

    TextView greeting;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        greeting = (TextView) findViewById(R.id.greeting);

        Bundle data = getIntent().getExtras();
        if(data != null){
            String name = "Hello, " + data.getString("username");
            greeting.setText(name);
        }

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signout = new Intent(GreetActivity.this, MainActivity.class);
                startActivity(signout);
            }
        });
    }
}