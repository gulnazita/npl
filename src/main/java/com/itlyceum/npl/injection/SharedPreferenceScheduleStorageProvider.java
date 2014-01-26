package com.itlyceum.npl.injection;

import android.content.SharedPreferences;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.itlyceum.npl.storage.ScheduleStorageInterface;
import com.itlyceum.npl.storage.SharedPreferenceScheduleStorage;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class SharedPreferenceScheduleStorageProvider implements Provider<ScheduleStorageInterface>{
    @Inject
    protected SharedPreferences sharedPreferences;

    @Override
    public ScheduleStorageInterface get() {
        return new SharedPreferenceScheduleStorage(sharedPreferences);
    }
}