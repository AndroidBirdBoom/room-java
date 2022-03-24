package com.bcqs.jetpack_room_java.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bcqs.jetpack_room_java.R;
import com.bcqs.jetpack_room_java.databinding.FragmentTopBinding;
import com.bcqs.jetpack_room_java.factory.CountVmFactory;
import com.bcqs.jetpack_room_java.viewmodel.CountViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TopFragment extends Fragment {

    private CountViewModel countViewModel;
    private FragmentTopBinding fragmentTopBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTopBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top,container,false);
        return fragmentTopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countViewModel = new ViewModelProvider(requireActivity(),new CountVmFactory()).get(CountViewModel.class);
        fragmentTopBinding.setTopCount(countViewModel.getCurrentCount());
        fragmentTopBinding.btnSend1.setOnClickListener(view1 -> {
            fragmentTopBinding.setTopCount(countViewModel.getCurrentCount());
            countViewModel.setCurrentCount(Integer.valueOf(fragmentTopBinding.etCount1.getText().toString()));
        });
    }
}
