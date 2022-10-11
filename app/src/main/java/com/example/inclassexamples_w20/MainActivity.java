package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);
        EditText textInput = (EditText) findViewById(R.id.EditTextBox);
        final Button button = (Button) findViewById(R.id.PRESSME);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView view = (TextView) findViewById(R.id.TextBox);
                String grabbedText = textInput.getText().toString();
                view.setText(grabbedText);
                String x = (String) getString(R.string.toast_message);
                toast(x);
            }
        });

    }
    public void toast(String msg){
        Context context = (Context) getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
