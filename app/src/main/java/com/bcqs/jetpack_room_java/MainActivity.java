package com.bcqs.jetpack_room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bcqs.jetpack_room_java.activity.ViewModelActivity;
import com.bcqs.jetpack_room_java.dao.UserDao;
import com.bcqs.jetpack_room_java.data.User;
import com.bcqs.jetpack_room_java.factory.VmFactory;
import com.bcqs.jetpack_room_java.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvData;
    EditText etData;
    Button btnAdd;
    Button btnVM;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvData = findViewById(R.id.tv_datas);
        etData = findViewById(R.id.et_data);
        btnAdd = findViewById(R.id.btn_add);
        btnVM = findViewById(R.id.btn_vm);
        btnAdd.setOnClickListener(view -> {
            addData();
        });
        btnVM.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewModelActivity.class);
            startActivity(intent);
        });

        mainViewModel = new ViewModelProvider(this,new VmFactory(getApplication())).get(MainViewModel.class);
        setTvData(mainViewModel.getUsers());
    }


    private void addData() {
        if (TextUtils.isEmpty(etData.getText().toString().trim())) {
            Toast.makeText(this, "不能为空！", Toast.LENGTH_SHORT);
            return;
        }
        String data = etData.getText().toString().trim();
        User user = new User(data, data);
        mainViewModel.setUser(user);
        setTvData(mainViewModel.getUsers());
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