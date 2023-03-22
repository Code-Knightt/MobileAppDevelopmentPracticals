package com.example.practical06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText former, latter;
    Button concat;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        concat = (Button) findViewById(R.id.button);
        former = (EditText) findViewById(R.id.former);
        latter = (EditText) findViewById(R.id.latter);

        concat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = former.getText().toString();
                s2 = latter.getText().toString();

                if(TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2)){
                    Toast.makeText(getApplicationContext(), "Either input field is empty", Toast.LENGTH_LONG).show();
                    return;
                }

                String concatText = s1+s2;
                Intent join = new Intent(MainActivity.this, ConcatenateActivity.class);
                Bundle data = new Bundle();
                data.putString("concat", concatText);
                join.putExtras(data);
                startActivity(join);

            }
        });
    }
}