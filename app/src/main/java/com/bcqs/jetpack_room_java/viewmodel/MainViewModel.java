package com.bcqs.jetpack_room_java.viewmodel;

import android.app.Application;

import com.bcqs.jetpack_room_java.db.AppDataBase;
import com.bcqs.jetpack_room_java.data.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

public class MainViewModel extends AndroidViewModel {

    private List<User> users;
    private AppDataBase dataBase;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dataBase = Room.databaseBuilder(application,AppDataBase.class,"bcqs").allowMainThreadQueries().build();
    }

    public List<User> getUsers(){
        users = dataBase.userDao().getAll();
        return users;
    }

    public void setUsers(List<User> users){
        dataBase.userDao().inserAll(users);
    }

    public void setUser(User user){
        dataBase.userDao().insertAll(user);
    }

}
