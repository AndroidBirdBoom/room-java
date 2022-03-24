package com.bcqs.jetpack_room_java.factory;

import com.bcqs.jetpack_room_java.viewmodel.CountViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CountVmFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CountViewModel();
    }
}
