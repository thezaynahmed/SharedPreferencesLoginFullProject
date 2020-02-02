package com.example.sharedpreferenceslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button btnLogin;
    CheckBox checkBox;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        checkBox = findViewById(R.id.cb);

        sharedPreferences = getSharedPreferences("username",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        checkBox.setChecked(sharedPreferences.getBoolean("checkBox", false));
        if (checkBox.isChecked()){
            user.setText(sharedPreferences.getString("username",""));
            pass.setText(sharedPreferences.getString("password", ""));
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user.getText().toString().equals("admin123") && pass.getText().toString().equals("1234")){

                    if (checkBox.isChecked()){
                        editor.putString("username", user.getText().toString());
                        editor.putString("password", pass.getText().toString());
                        editor.putBoolean("checkBox",true);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "Remembered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("username", "");
                        editor.putString("password", "");
                        editor.putBoolean("checkBox", false);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "NO VALUE", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
