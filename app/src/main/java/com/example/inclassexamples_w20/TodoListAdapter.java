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

public class TodoListAdapter extends ArrayAdapter<ToDo>{
    private Context mContext;
    int mResource;
    public TodoListAdapter(Context context, int resource, ArrayList<ToDo> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String todo = getItem(position).getTodo();
        boolean urgent = getItem(position).getUrgent();
        ToDo toDo = new ToDo(todo,urgent);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvTodo = (TextView) convertView.findViewById(R.id.textView1);
        if (urgent){
            tvTodo.setBackgroundResource(R.color.cool);
            tvTodo.setTextColor(Color.parseColor("#FFFFFF"));
        }
        tvTodo.setText(todo);
        return convertView;
    }
}
