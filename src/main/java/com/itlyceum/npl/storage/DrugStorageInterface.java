package com.itlyceum.npl.storage;

import com.itlyceum.npl.model.Drug;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 * Интерфейс для работы с лекарствами.Сохранение/получение из хранилищ
 */
public interface DrugStorageInterface {
    /**
     * Сохранение лекарства
     * @param drug
     */
    public void save(Drug drug);

    /**
     * Получение лекарства по id
     * @param id
     */
    public Drug getById(int id);
    public Drug[] getAll();

    /**
     * Удаление лекарства из хранилища
     * @param drug
     */
    public void remove(Drug drug);

    /**
     * Удаление лекарства по id из хранилища
     * @param id
     */
    public void removeById(int id);

}