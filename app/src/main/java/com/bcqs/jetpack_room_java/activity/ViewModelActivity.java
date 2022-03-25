package com.bcqs.jetpack_room_java.activity;

import android.os.Bundle;

import com.bcqs.jetpack_room_java.R;
import com.bcqs.jetpack_room_java.databinding.ActivityViewmodelBinding;
import com.bcqs.jetpack_room_java.factory.CountVmFactory;
import com.bcqs.jetpack_room_java.fragment.BottomFragment;
import com.bcqs.jetpack_room_java.fragment.TopFragment;
import com.bcqs.jetpack_room_java.viewmodel.CountViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelActivity extends AppCompatActivity {

    private ActivityViewmodelBinding activityViewmodelBinding;
    private CountViewModel countViewModel;

    private TopFragment topFragment;
    private BottomFragment bottomFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityViewmodelBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel);
        countViewModel = new ViewModelProvider(this,new CountVmFactory()).get(CountViewModel.class);
        countViewModel.getCurrentCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                activityViewmodelBinding.setCount(integer);
            }
        });
        countViewModel.startTiming();
        activityViewmodelBinding.tvStart.setOnClickListener(view -> {
            if (activityViewmodelBinding.tvStart.getText().toString().trim().equals("启动")){
                activityViewmodelBinding.tvStart.setText("停止");
            }else {
                activityViewmodelBinding.tvStart.setText("启动");
            }
        });

        topFragment = new TopFragment();
        bottomFragment = new BottomFragment();
        FragmentTransaction ftt =getSupportFragmentManager().beginTransaction();
        ftt.add(R.id.frame1,topFragment);
        ftt.commit();
        FragmentTransaction ftb = getSupportFragmentManager().beginTransaction();
        ftb.add(R.id.frame2,bottomFragment);
        ftb.commit();

    }
}
