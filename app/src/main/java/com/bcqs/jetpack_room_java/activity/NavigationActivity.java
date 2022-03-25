package com.bcqs.jetpack_room_java.activity;

import android.os.Bundle;

import com.bcqs.jetpack_room_java.R;
import com.bcqs.jetpack_room_java.databinding.ActivityNavigationBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding activityNavigationBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNavigationBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
    }
}
