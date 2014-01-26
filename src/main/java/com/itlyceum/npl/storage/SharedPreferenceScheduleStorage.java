package com.itlyceum.npl.storage;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.itlyceum.npl.model.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class SharedPreferenceScheduleStorage implements ScheduleStorageInterface {
    protected SharedPreferences storage;
    protected final static String PREFIX ="sch";

    public SharedPreferenceScheduleStorage(SharedPreferences sp) {
        storage= sp;
    }

    @Override
    public void save(Schedule schedule) {
        SharedPreferences.Editor editor = storage.edit();
        editor.putString(getKeyForId(schedule.getId()), convertSchedule2String(schedule));
        editor.commit();
    }

    @Override
    public Schedule getById(int scheduleId) {
        return convertString2Schedule(storage.getString(getKeyForId(scheduleId), ""));
    }

    @Override
    public Schedule[] getAll() {
        List<Schedule> allSchedules = new ArrayList<Schedule>();
        Map<String,?> allItems = storage.getAll();
        for (Map.Entry<String,?> entry: allItems.entrySet() ){
            if (entry.getKey().startsWith(PREFIX))
            {
                allSchedules.add(convertString2Schedule((String)entry.getValue()));
            }
        }

        return allSchedules.toArray(new Schedule[allSchedules.size()]);
    }

    @Override
    public void remove(Schedule schedule) {
        SharedPreferences.Editor editor = storage.edit();
        editor.remove(getKeyForSchedule(schedule));
        editor.commit();
    }

    @Override
    public void removeById(int scheduleId) {
        SharedPreferences.Editor editor = storage.edit();
        editor.remove(getKeyForId(scheduleId));
        editor.commit();
    }

    private String getKeyForSchedule(Schedule schedule) {
        return String.format("%s_%s",PREFIX, schedule.getId());
    }

    private String getKeyForId( int id){
        return String.format("%s_%s",PREFIX,id);
    }

    private String convertSchedule2String (Schedule schedule){
        return new Gson().toJson(schedule);
    }
    private Schedule convertString2Schedule (String json){
       Gson gson = new Gson();
        Schedule schedule = gson.fromJson(json, Schedule.class);
        return schedule;
    }
}
