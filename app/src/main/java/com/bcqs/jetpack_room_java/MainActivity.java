package com.bcqs.jetpack_room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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
import com.bcqs.jetpack_room_java.databinding.ActivityMainBinding;
import com.bcqs.jetpack_room_java.factory.VmFactory;
import com.bcqs.jetpack_room_java.observer.LifecyceListener;
import com.bcqs.jetpack_room_java.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding activityMainBinding;

    private LifecyceListener lifecyceListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.btnAdd.setOnClickListener(view -> {
            addData();
        });
        activityMainBinding.btnVm.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewModelActivity.class);
            startActivity(intent);
        });

        mainViewModel = new ViewModelProvider(this, new VmFactory(getApplication())).get(MainViewModel.class);
        setTvData(mainViewModel.getUsers());

/*        //lifecycle
        lifecyceListener = new LifecyceListener();
        getLifecycle().addObserver(lifecyceListener);*/

    }


    private void addData() {
        if (TextUtils.isEmpty(activityMainBinding.etData.getText().toString().trim())) {
            Toast.makeText(this, "不能为空！", Toast.LENGTH_SHORT);
            return;
        }
        String data = activityMainBinding.etData.getText().toString().trim();
        User user = new User(data, data);
        mainViewModel.setUser(user);
        setTvData(mainViewModel.getUsers());
    }

    private void setTvData(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (i == 0) {
                activityMainBinding.tvDatas.setText(users.get(i).toString());
            } else {
                activityMainBinding.tvDatas.setText(activityMainBinding.tvDatas.getText().toString().trim() + "\n" + users.get(i).toString());
            }
        }
    }
}