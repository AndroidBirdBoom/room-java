package com.bcqs.jetpack_room_java;

import com.bcqs.jetpack_room_java.dao.UserDao;
import com.bcqs.jetpack_room_java.data.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
