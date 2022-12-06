package com.example.inclassexamples_w20;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

// Creating an ADAPTER class that extends the ARRAYADAPTER super class
// passing my ToDo.java class in as a parameter for that ARRAY ADAPTER class.
public class TodoListAdapter extends ArrayAdapter<ToDo>{

    //  Creating a private variable from the Context object?
    private Context mContext;

    // Not sure what mResource is in this context
    // The resource parameter is the ID of the layout
    int mResource;

    // Creating a method using the parent class of the same name
    public TodoListAdapter(Context context, int resource, ArrayList<ToDo> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    // NOT SURE WHY THIS HAS TO BE NONNULL
    @NonNull
    @Override

    // NOT SURE WHAT'S GOING ON HERE EITHER
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // INITIALIZING THE VARIABLES
        String todo = getItem(position).getTodo();
        int urgent = getItem(position).getUrgent();
        ToDo toDo = new ToDo(todo,urgent);

        // DON'T REMEMBER WHAT A LAYOUT INFLATER IS
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvTodo = (TextView) convertView.findViewById(R.id.textView1);

        // IF THE CHECKBOX URGENT VARIABLE IS SET TO TRUE DO THE FOLLOWING
        if (urgent >= 1){

            // SET THE BACKGROUND OF THE TEXTVIEW ITEM IS URGENT - CHANGE THE BACKGROUND COLOR
            tvTodo.setBackgroundResource(R.color.cool);
            tvTodo.setTextColor(Color.parseColor("#FFFFFF"));
        }

        // NOT SURE WHAT'S HAPPENING HERE
        tvTodo.setText(todo);

        // NOT SURE WHAT'S HAPPENING HERE EITHER.
        return convertView;
    }
}
