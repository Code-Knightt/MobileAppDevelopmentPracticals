package com.example.practical14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar, bottom_toolbar;
    LinearLayout screen;
    TextView screenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottom_toolbar = (Toolbar) findViewById(R.id.bottom_toolbar);
        setSupportActionBar(toolbar);

        bottom_toolbar.inflateMenu(R.menu.bg_menu);
        toolbar.inflateMenu(R.menu.bg_menu);

        screen = (LinearLayout) findViewById(R.id.screen);
        screenText = (TextView) findViewById(R.id.screen_text);
        screen.setBackgroundColor(getResources().getColor(R.color.red));

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item1) {
                    screen.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (item.getItemId() == R.id.item2) {
                    screen.setBackgroundColor(getResources().getColor(R.color.green));
                } else if (item.getItemId() == R.id.item3) {
                    screen.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                return false;
            }
        });

        bottom_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item1) {
                    screenText.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (item.getItemId() == R.id.item2) {
                    screenText.setBackgroundColor(getResources().getColor(R.color.green));
                } else if (item.getItemId() == R.id.item3) {
                    screenText.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bg_menu, menu);
        return true;
    }
}