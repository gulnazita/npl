package com.itlyceum.npl.injection;

import android.content.SharedPreferences;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.itlyceum.npl.storage.DrugStorageInterface;
import com.itlyceum.npl.storage.SharedPreferenceDrugStorage;


/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class SharedPreferenceDrugStorageProvider implements Provider<DrugStorageInterface> {
    @Inject
    protected SharedPreferences sharedPreferences;

    @Override
    public DrugStorageInterface get() {
        return new SharedPreferenceDrugStorage(sharedPreferences);
    }
}
