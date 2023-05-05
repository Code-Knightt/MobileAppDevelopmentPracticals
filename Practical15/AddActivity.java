package com.example.practical15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText enrollment, firstName, lastName;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final DBHelper resumeDbHelper = new DBHelper(this);

        enrollment = (EditText) findViewById(R.id.add_enrollment);
        firstName = (EditText) findViewById(R.id.add_first_name);
        lastName = (EditText) findViewById(R.id.add_last_name);
        addButton = (Button) findViewById(R.id.add_addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String enr = enrollment.getText().toString();
                    String fname = firstName.getText().toString();
                    String lname = lastName.getText().toString();

                    long id = resumeDbHelper.addResume(enr, fname, lname);
                    Toast.makeText(getApplicationContext(),"Your record has been saved successfully with ID"+id,Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}