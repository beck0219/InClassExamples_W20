package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText EditText_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText_name = findViewById(R.id.edit_text_name_input);

        // BUTTON INITIALIZATION
        Button save_data_button = findViewById(R.id.button_save_data);
        save_data_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nameString = EditText_name.getText().toString();
                // INTENT STUFF
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivityForResult(intent, 1);
                // SHARED PREFERENCES
                SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameString);
                editor.commit();
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();

    }


}