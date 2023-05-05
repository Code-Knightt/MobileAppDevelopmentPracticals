package com.example.practical15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText enrollment, firstName, lastName;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final DBHelper resumeDbHelper = new DBHelper(this);

        enrollment = (EditText) findViewById(R.id.update_enrollment);
        firstName = (EditText) findViewById(R.id.update_first_name);
        lastName = (EditText) findViewById(R.id.update_last_name);
        updateButton = (Button) findViewById(R.id.update_updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String enr = enrollment.getText().toString();
                    String fname = firstName.getText().toString();
                    String lname = lastName.getText().toString();

                    boolean isUpdated = resumeDbHelper.updateEmployee(enr, fname, lname);
                    if(isUpdated){
                        Toast.makeText(getApplicationContext(), "Resume updated successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error updating resume", Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}