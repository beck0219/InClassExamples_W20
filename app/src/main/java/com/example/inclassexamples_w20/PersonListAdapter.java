package com.example.inclassexamples_w20;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter <String>{
    public PersonListAdapter(@NonNull Context context, int resource, ArrayList<String> arrayList) {
        super(context, resource);
    }
}
