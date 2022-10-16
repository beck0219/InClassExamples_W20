package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //CONSTRUCT OBJECTS
        TextView name_result = findViewById(R.id.text_view_name_result);
        Button dontcallmethat = findViewById(R.id.button_dontcallmethat);
        Button thankyou = findViewById(R.id.button_thankyou);

        //GET THE NAME VALUE FROM "SHARED_PREFS"
        SharedPreferences sp = getApplicationContext().getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        name_result.setText(getString(R.string.welcome_name) + name +"!");

        dontcallmethat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              setResult(0);
              finish();
            }
        });

        thankyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                System.exit(1);
            }
        });

    }
}