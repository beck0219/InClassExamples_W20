package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.sql.SQLDataException;
import java.util.ArrayList;

public class MainActivity<Int> extends AppCompatActivity  {

    EditText editText;
    Button button;
    Switch button_urgent;
    int button_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.text_input);
        button = findViewById(R.id.button_add);
        button_urgent = findViewById(R.id.switch_urgent);

        ListView taskList = (ListView) findViewById(R.id.listView);
        ArrayList<ToDo> todoList = new ArrayList<>();
        TodoListAdapter adapter = new TodoListAdapter(this, R.layout.adapter_view_layout, todoList);
        MySQLiteHelper db = new MySQLiteHelper(this);
        Cursor data = db.getListContents();

        if (data.getCount() == 0 ){
            Toast.makeText(MainActivity.this, "The database is empty", Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                ToDo p = new ToDo(data.getString(1), data.getInt(2));
                todoList.add(p);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        }
        taskList.setAdapter(adapter);
        taskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int listitem, long l) {
                // CREATING AN ALERT DIALOG BOX WINDOW TO POP UP - WARNING THE USER THAT THIS ACTION IS IMPORTANT
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete '" + todoList.get(listitem)+ "' from the list?")
                        // CLICK YES - DO THE FOLLOWING
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String taskName = todoList.get(listitem).toString();
                                  db.deleteTaskListItem(taskName);
                                  Toast.makeText(MainActivity.this, "Task deleted from the ToDo List", Toast.LENGTH_SHORT).show();
                                  Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                  startActivity(intent);
                            }
                        // CLICK NO - DO THE FOLLOWING
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
                return false;
            }
        });

        //  BUTTON LISTENER IS LISTENING FOR WHEN OUR BUTTON IS PRESSED - DO SOMETHING!
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String taskName = editText.getText().toString();
                if (taskName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a task name...", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                db.addNewTask(taskName,button_status);
                data.moveToLast();
                editText.setText("");
            }
        });
        //  THIS BUTTON LISTENER IS WAITING TO SEE IF THE URGENT CHECKBOX IS CHECKED OR NOT.
        button_urgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // IF THE CHECKBOX IS CHECKED -> SET THE VALUE OF OUR BUTTON_STATUS VARIABLE TO TRUE / 1
                if (button_urgent.isChecked()){
                    button_status = 1;
                }
                // IF THE CHECKBOX IS NOT CHECKED -> SET THE VALUE OF OUR BUTTON_STATUS VARIABLE TO FALSE / 0
                else{
                    button_status = 0;
                }
            }
        });
    }
}