package com.itlyceum.npl.injection;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.itlyceum.npl.storage.DrugStorageInterface;
import com.itlyceum.npl.storage.ScheduleStorageInterface;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class CommonModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(ScheduleStorageInterface.class).toProvider(SharedPreferenceScheduleStorageProvider.class);
        binder.bind(DrugStorageInterface.class).toProvider(SharedPreferenceDrugStorageProvider.class);
    }
}
