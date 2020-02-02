package com.example.sharedpreferenceslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
    }
    public void onBackPressed() {
        moveTaskToBack(false);
        Toast.makeText(this, "Can't Go Back", Toast.LENGTH_SHORT).show();
    }

}
