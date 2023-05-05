package com.example.practical15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    Button deleteButton;
    EditText enrollment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        enrollment = (EditText) findViewById(R.id.delete_enrollment);
        deleteButton = (Button) findViewById(R.id.delete_deleteButton);

        final DBHelper resumeDbHelper = new DBHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDeleted = resumeDbHelper.deleteEmployee(enrollment.getText().toString());

                if(isDeleted){
                    Toast.makeText(getApplicationContext(), "Resume deleted successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error deleting resume", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}