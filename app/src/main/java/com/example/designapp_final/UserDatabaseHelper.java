package com.example.designapp_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.designapp_final.models.User;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Users.db";
    public static final String allUserTable = "allusers";

    public UserDatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(email TEXT  primary key, password TEXT, name TEXT, image BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("drop Table if exists allusers");
    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert(allUserTable, null, contentValues);

        if(result == -1){
            return false;
        } else{
            return true;
        }
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from "+allUserTable+" where email =?", new String[]{email});

        return cursor.getCount() > 0;
    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from "+allUserTable+" where email =? and password =?", new String[]{email, password});

        if(cursor.getCount() >0){
            return true;
        } else {
            return false;
        }

    }

    public boolean isUsersEmpty() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from "+allUserTable, null);
        return cursor.getCount() <= 0;
    }
    // getUser method

    public User getUser() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from "+allUserTable, null);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            String email = cursor.getString(0);
            String password = cursor.getString(1);
            String name = cursor.getString(2);
            User user = new User(email, password, name);
            byte[] image = cursor.getBlob(3);
            user.setImage(image);
            return user;
        } else {
            return null;
        }
    }

public boolean updateUser(User user) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        contentValues.put("name", user.getName());
        contentValues.put("image", user.getImage());
        long result = MyDatabase.update(allUserTable, contentValues, "email=?", new String[]{user.getEmail()});
        if(result == -1){
            return false;
        } else{
            return true;
        }
    }
}
