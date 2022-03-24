package com.bcqs.jetpack_room_java.factory;

import android.app.Application;

import com.bcqs.jetpack_room_java.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class VmFactory extends ViewModelProvider.AndroidViewModelFactory {

    /**
     * Creates a {@code AndroidViewModelFactory}
     *
     * @param application an application to pass in {@link AndroidViewModel}
     */
    public VmFactory(@NonNull Application application) {
        super(application);
    }
}
