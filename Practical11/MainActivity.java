package com.example.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_01, cb_02, cb_03;
    Button select;
    Toast toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_01 = (CheckBox) findViewById(R.id.checkBox_01);
        cb_02 = (CheckBox) findViewById(R.id.checkBox_02);
        cb_03 = (CheckBox) findViewById(R.id.checkBox_03);
        select = (Button) findViewById(R.id.button);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!cb_01.isChecked() && !cb_02.isChecked() && !cb_03.isChecked()){
                    if(toastMessage != null){
                        toastMessage.cancel();
                    }
                    toastMessage = Toast.makeText(getApplicationContext(), "Select at least one hobby", Toast.LENGTH_LONG);
                    toastMessage.show();
                    return;
                }

                StringBuilder hobbies = new StringBuilder("Selected hobbies:\n");

                if(cb_01.isChecked()){
                    hobbies.append(cb_01.getText().toString()).append(", ");
                }
                if(cb_02.isChecked()){
                    hobbies.append(cb_02.getText().toString()).append(", ");
                }
                if(cb_03.isChecked()){
                    hobbies.append(cb_03.getText().toString()).append(", ");
                }
                String display = hobbies.substring(0, hobbies.length()-2).toString();

                if(toastMessage != null){
                    toastMessage.cancel();
                }

                toastMessage = Toast.makeText(getApplicationContext(), display, Toast.LENGTH_LONG);
                toastMessage.show();
                hobbies.setLength(0);
            }
        });
    }
}