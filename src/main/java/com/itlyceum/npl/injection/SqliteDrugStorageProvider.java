package com.itlyceum.npl.injection;

import com.google.inject.Provider;
import com.itlyceum.npl.storage.DrugStorageInterface;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class SqliteDrugStorageProvider implements Provider<DrugStorageInterface> {
    @Override
    public DrugStorageInterface get() {
        return null;
    }
}
