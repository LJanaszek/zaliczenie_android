package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class UpDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static volatile UpDatabase INSTANCE;

    public static UpDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UpDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UpDatabase.class, "students")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
