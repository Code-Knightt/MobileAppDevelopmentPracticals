package com.example.practical09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup branches;
    Toast toastMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        branches = (RadioGroup) findViewById(R.id.branches);

        branches.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton selectedBranch = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                String branch = selectedBranch.getText().toString();

                if(toastMessage != null){
                    toastMessage.cancel();
                }
                toastMessage = Toast.makeText(getApplicationContext(), "Branch: "+branch, Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });
    }
}