package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button button;
    ListView listView;

    ArrayList<String> arrayList;
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.veri);
        button=findViewById(R.id.kaydet);
        listView=findViewById(R.id.Liste);

        arrayList=new ArrayList<>();
//        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, arrayList);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String YeniVeri= editText.getText().toString();
                arrayList.add(YeniVeri);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, " "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}