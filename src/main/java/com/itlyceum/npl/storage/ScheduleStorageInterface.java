package com.itlyceum.npl.storage;

import com.itlyceum.npl.model.Schedule;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public interface ScheduleStorageInterface {
    public void save (Schedule schedule);
    public Schedule getById (int scheduleId);
    public Schedule[] getAll();
    public void remove (Schedule schedule);
    public void removeById (int scheduleId);

}
