package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    EditText editText;
    Button button;
    Switch button_urgent;
    boolean button_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);
        TextView mTextView = (TextView) findViewById(R.id.textView1);
        editText = findViewById(R.id.text_input);
        button=findViewById(R.id.button_add);
        button_urgent = findViewById(R.id.switch_urgent);
        ArrayList<ToDo> todoList = new ArrayList<>();
        TodoListAdapter adapter = new TodoListAdapter(this, R.layout.adapter_view_layout, todoList);
        mListView.setAdapter(adapter);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int listitem, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Do you want to delete this" + todoList.get(listitem)+ "from the list?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                todoList.remove(listitem);
                                adapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ToDo p = new ToDo(editText.getText().toString(),button_status);
                todoList.add(p);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        button_urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button_urgent.isChecked()){
                    button_status = true;
                }
                else{
                    button_status = false;
                }
            }
        });
    }
}