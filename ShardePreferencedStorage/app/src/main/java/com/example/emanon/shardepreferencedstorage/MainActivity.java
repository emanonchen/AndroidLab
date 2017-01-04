package com.example.emanon.shardepreferencedstorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.R.id.edit;
import static java.lang.reflect.Array.getInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = (Button) findViewById(R.id.save_data);
        Button restoreData = (Button) findViewById(R.id.restore_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("Name" , "Emanon");
                editor.putInt("Age", 28);
                editor.putBoolean("Genius", true);
                editor.commit();
            }
        });
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name =  pref.getString("Name", "");
                int age = pref.getInt("Age", 99);
                boolean genius = pref.getBoolean("Genius", false);
                Log.d("MainActivity", "Name is " + name);
                Log.d("MainActivity", "Age is " + age);
                Log.d("MainActivity", "Genius" + genius);
            }
        });
    }
}
