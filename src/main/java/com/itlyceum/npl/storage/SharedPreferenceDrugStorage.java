package com.itlyceum.npl.storage;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.itlyceum.npl.model.Drug;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class SharedPreferenceDrugStorage implements DrugStorageInterface {
    protected SharedPreferences storage;
    protected final static String PREFIX = "dr";

    public SharedPreferenceDrugStorage(SharedPreferences sp) {
        storage = sp;
    }

    @Override
    public void save(Drug drug) {
        SharedPreferences.Editor editor = storage.edit();
        editor.putString(getKeyForDrug(drug),convertDrug2String(drug));
        editor.commit();
    }

    @Override
    public Drug getById(int id) {
        return convertString2Drug(storage.getString(getKeyForId(id), ""));
    }

    @Override
    public Drug[] getAll() {
        List<Drug> allDrugs = new ArrayList<Drug>();
        Map<String, ?> allItems = storage.getAll();
        for(Map.Entry <String,?> entry: allItems.entrySet()){
            String currentItemKey = entry.getKey();
            if (currentItemKey.startsWith(PREFIX)){
                allDrugs.add(convertString2Drug((String)entry.getValue()));
            }
        }

        return allDrugs.toArray(new Drug[allDrugs.size()]);
    }

    @Override
    public void remove(Drug drug) {
        SharedPreferences.Editor editor = storage.edit();
        editor.remove(getKeyForDrug(drug));
        editor.commit();
    }

    @Override
    public void removeById(int id) {
        SharedPreferences.Editor editor = storage.edit();
        editor.remove(getKeyForId(id));
        editor.commit();

    }

    private String getKeyForDrug(Drug drug){
        return String.format("%s_%s", PREFIX, drug.getId());
    }
    private String getKeyForId(int id){
        return String.format("%s_%s",PREFIX,id);
    }

    private String convertDrug2String(Drug drug){
        return new Gson().toJson(drug);
    }

    private Drug convertString2Drug(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Drug.class);
    }
}
