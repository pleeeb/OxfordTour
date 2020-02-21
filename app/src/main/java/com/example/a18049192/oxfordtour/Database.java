package com.example.a18049192.oxfordtour;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class, TG.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract TGDao tgDao();

    private static volatile Database databaseInstance;

    static Database getDatabase(final Context context){
        if (databaseInstance == null){
            synchronized (Database.class){
                if (databaseInstance == null){
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "database").build();
                }
            }
        }
        return databaseInstance;
    }
}
