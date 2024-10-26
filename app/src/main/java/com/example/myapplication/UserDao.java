package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

//    @Query("SELECT * FROM users WHERE id = 1")
//    List<User> getAll();
    @Query("SELECT * FROM users")
    List<User> getAllUsers();
}
