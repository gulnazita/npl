package com.itlyceum.npl.storage;

import com.itlyceum.npl.model.Drug;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 * //todo до лучших времен
 */
public class SqliteDrugStorage implements DrugStorageInterface {
    @Override
    public void save(Drug drug) {

    }

    @Override
    public Drug getById(int id) {
        return null;
    }

    @Override
    public Drug[] getAll() {
        return new Drug[0];
    }

    @Override
    public void remove(Drug drug) {

    }

    @Override
    public void removeById(int id) {

    }
}
