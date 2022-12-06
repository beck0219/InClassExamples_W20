package com.example.inclassexamples_w20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
import java.util.ArrayList;

// Subclassing the SQLiteOpenHelper class
public class MySQLiteHelper extends SQLiteOpenHelper {

    // Composing the SQL statement for the database / table creation
    // Database name variable
    private static final String DATABASE_NAME = "ToDoListDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table name variables
    private static final String TABLE_NAME = "ToDoListTable";
    private static final String ID_COL = "id";
    private static final String TASK_COL = "task";
    private static final String URGENCY_COL = "urgency";

    // Database Table Creation statement
        // May have messed something up when I added the 'urgency_col' -> something to do with the quotations.
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + " ( " + ID_COL + " integer primary key autoincrement, " + TASK_COL + " text not null, " + URGENCY_COL + " text not null);";

    // OLD!
    // Calling the super class constructor
    //    public MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    //        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    //    }

    // NEW!
    // Calling the super class constructor without all the extra stuff above
    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Executing an SQL statement using our String DATABASE_CREATE
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    // Creating the method to add new task rows to our to do list database
    public void addNewTask(String taskName, int urgencyStatus){

        // Creating easy variable for the the SQLite database and calling the write method
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating ContentValues variable
        ContentValues values = new ContentValues();

        // Passing along the values we want to add to the table column
        values.put(TASK_COL, taskName);
        values.put(URGENCY_COL, urgencyStatus);

        // pass the ContentValues to the Table
        db.insert(TABLE_NAME, null, values);

        // Close the database afterwards
        db.close();
    }

    // Creating the method to read all the tasks
   public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
   }

   // method for deleting a row from the database
    public void deleteTaskListItem(String taskName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "task=?",new String[]{taskName});
        db.close();
    }
}
