package com.bcqs.jetpack_room_java.dao;

import com.bcqs.jetpack_room_java.data.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Insert
    void insertTargetUsers(User user1, User user2);

    @Insert
    void insertUserAndFriends(User user, List<User> friends);

    @Delete
    void delete(User user);

    @Delete
    void deleteUsers(User... users);

    @Update
    void updateUsers(User... users);
}
