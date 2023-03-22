package com.example.practical13;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    TextView text;
    RadioGroup group;
    RadioButton b, it, bi, n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.changeText);
        group = (RadioGroup) findViewById(R.id.group);

        b = (RadioButton) findViewById(R.id.rb_01);
        it = (RadioButton) findViewById(R.id.rb_02);
        bi = (RadioButton) findViewById(R.id.rb_03);
        n = (RadioButton) findViewById(R.id.rb_04);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedId = radioGroup.getCheckedRadioButtonId();

                if(checkedId == b.getId()){
                    text.setTypeface(text.getTypeface(), Typeface.BOLD);
                } else if(checkedId == it.getId()){
                    text.setTypeface(text.getTypeface(), Typeface.ITALIC);
                } else if(checkedId == bi.getId()){
                    text.setTypeface(text.getTypeface(), Typeface.BOLD_ITALIC);
                } else {
                    text.setTypeface(Typeface.DEFAULT);
                }

            }
        });
    }
}