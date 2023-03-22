package com.example.practical06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConcatenateActivity extends AppCompatActivity {

    TextView result;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concatenate);

        result = (TextView) findViewById(R.id.result);
        String concat = null;
        Bundle data = getIntent().getExtras();

        if(data != null){
            concat = data.getString("concat");
        }
        result.setText(concat);

        backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ConcatenateActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}