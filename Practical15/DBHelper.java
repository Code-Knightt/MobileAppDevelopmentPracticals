package com.example.practical15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper {

//    public static final String EmpId = "EmpId";
//    public static final String EmpName = "EmpName";
//    public static final String EmpSal = "EmpSal";
//    public static final String databaseName = "EmployeeDB";
//    public static final String tableName = "Employee";

    public static final String Enroll = "EnrollmentID";
    public static final String FirstName = "FirstName";
    public static final String LastName = "LastName";
    public static final String databaseName = "ResumeDB";
    public static final String tableName = "Resume";
    private static final int databaseVersion = 1;
    private static final String create_table = "create table "+ tableName +"("+ Enroll +" text primary key, " + FirstName + " text not null, " + LastName + " text not null)";
    private final Context ct;
    private static DatabaseHelper dbHelper;
    private static SQLiteDatabase database;

    public DBHelper(Context ct) {
        this.ct = ct;
        dbHelper = new DatabaseHelper(ct);
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context c) {
            super(c, databaseName, null, databaseVersion);
        }

        public void onCreate(SQLiteDatabase database) {
            try {
                database.execSQL(create_table);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Employee");
            onCreate(db);
        }
    }

    public DBHelper connect() throws SQLException{
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void disconnect(){
        dbHelper.close();
    }

    public long addResume(String enrollment, String firstName, String lastName){
        ContentValues cv = new ContentValues();
        cv.put(Enroll, enrollment);
        cv.put(FirstName, firstName);
        cv.put(LastName, lastName);
        this.connect();
        return database.insert(tableName,null, cv);
    }

    public Cursor findResume(String enrollment){
        this.connect();
        Cursor c = database.query(tableName, null, Enroll+"="+enrollment, null, null, null, null);
        if(c!=null)
        {
            c.moveToFirst();
        }
        return c;
    }

    public boolean deleteEmployee(String enrollment){
        this.connect();
        return database.delete(tableName,Enroll + "=" +enrollment,null)>0;
    }

    public boolean updateEmployee(String enrollment, String firstName, String lastName){
        this.connect();
        ContentValues cv = new ContentValues();
        cv.put(Enroll, enrollment);
        cv.put(FirstName, firstName);
        cv.put(LastName, lastName);
        return database.update(tableName, cv,Enroll+"="+enrollment,null)>0;
    }

}

