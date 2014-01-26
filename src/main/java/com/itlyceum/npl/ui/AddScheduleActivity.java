package com.itlyceum.npl.ui;

import android.os.Bundle;
import android.view.View;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.google.inject.Inject;
import com.itlyceum.npl.R;
import com.itlyceum.npl.model.Schedule;
import com.itlyceum.npl.storage.ScheduleStorageInterface;

import java.util.Date;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class AddScheduleActivity extends RoboSherlockFragmentActivity {
    @Inject
    ScheduleStorageInterface scheduleStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        getSupportActionBar().setTitle(R.string.add_schedule_activity_title);
    }

    public void saveForm() {
        /*Schedule schedule1 = new Schedule();
        schedule1.setTitle("For Grandpa");
        schedule1.setDrug(drug1);
        schedule1.setRepeat(Schedule.Repeat.Day);
        schedule1.setStartDate(new Date());
        schedule1.setDescription("Universal drug.jfdksfuaskfbajb");*/

        //scheduleStorage.save(schedule1);
        finish();
    }
}
