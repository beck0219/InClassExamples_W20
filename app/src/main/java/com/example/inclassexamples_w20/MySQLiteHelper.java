package com.example.inclassexamples_w20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
import java.util.ArrayList;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ToDoListDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table name variables
    private static final String TABLE_NAME = "ToDoListTable";
    private static final String ID_COL = "id";
    private static final String TASK_COL = "task";
    private static final String URGENCY_COL = "urgency";
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + " ( " + ID_COL + " integer primary key autoincrement, " + TASK_COL + " text not null, " + URGENCY_COL + " text not null);";

    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void addNewTask(String taskName, int urgencyStatus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TASK_COL, taskName);
        values.put(URGENCY_COL, urgencyStatus);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

   public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
   }

    public void deleteTaskListItem(String taskName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "task=?",new String[]{taskName});
        db.close();
    }
}
