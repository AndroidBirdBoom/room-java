package com.bcqs.jetpack_room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bcqs.jetpack_room_java.dao.UserDao;
import com.bcqs.jetpack_room_java.data.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvData;
    EditText etData;
    Button btnAdd;

    private AppDataBase appDataBase;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tv_datas);
        etData = findViewById(R.id.et_data);
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(view -> {
            addData();
        });

        appDataBase = Room.databaseBuilder(this, AppDataBase.class, "bcqs").build();
        userDao = appDataBase.userDao();

        Thread thread = new Thread(runnable);
        thread.start();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            List<User> users = userDao.getAll();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setTvData(users);
                }
            });
        }
    };

    private void addData() {
        if (TextUtils.isEmpty(etData.getText().toString().trim())) {
            Toast.makeText(this, "不能为空！", Toast.LENGTH_SHORT);
            return;
        }
        String data = etData.getText().toString().trim();
        User user = new User(data, data);
        new Thread(new Runnable() {
            @Override
            public void run() {
                userDao.insertAll(user);
                new Thread(runnable).start();
            }
        }).start();

    }

    private void setTvData(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (i == 0) {
                tvData.setText(users.get(i).toString());
            } else {
                tvData.setText(tvData.getText().toString().trim() + "\n" + users.get(i).toString());
            }
        }
    }
}