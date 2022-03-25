package com.bcqs.jetpack_room_java.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bcqs.jetpack_room_java.R;
import com.bcqs.jetpack_room_java.databinding.FragmentBottomBinding;
import com.bcqs.jetpack_room_java.databinding.FragmentTopBinding;
import com.bcqs.jetpack_room_java.factory.CountVmFactory;
import com.bcqs.jetpack_room_java.viewmodel.CountViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class BottomFragment extends Fragment {
    private CountViewModel countViewModel;
    private FragmentBottomBinding fragmentBottomBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBottomBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom,container,false);
        return fragmentBottomBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countViewModel = new ViewModelProvider(requireActivity(),new CountVmFactory()).get(CountViewModel.class);
        fragmentBottomBinding.btnSend2.setOnClickListener(view1 -> {
            countViewModel.setCurrentCount(Integer.valueOf(fragmentBottomBinding.etCount2.getText().toString()));
        });
        countViewModel.getCurrentCount().observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                fragmentBottomBinding.setBottomCount(integer);
            }
        });
    }
}
