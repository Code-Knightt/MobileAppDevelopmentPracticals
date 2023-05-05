package com.example.practical15;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GetActivity extends AppCompatActivity {

    EditText inputEnrollment;
    Button getButton;
    TextView enroll, firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        final DBHelper resumeDbHelper = new DBHelper(this);

        inputEnrollment = (EditText) findViewById(R.id.get_enrollment);
        getButton = (Button) findViewById(R.id.get_getButton);

        enroll = (TextView) findViewById(R.id.get_setEnroll);
        firstName = (TextView) findViewById(R.id.get_setFirstName);
        lastName = (TextView) findViewById(R.id.get_setLastName);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor c = resumeDbHelper.findResume(inputEnrollment.getText().toString());

                    if(c.moveToFirst()){
                        enroll.setText(c.getString(0));
                        firstName.setText(c.getString(1));
                        lastName.setText(c.getString(2));
                    } else {
                        Toast.makeText(getApplicationContext(), "No result found", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}