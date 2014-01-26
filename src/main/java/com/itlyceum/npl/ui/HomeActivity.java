
package com.itlyceum.npl.ui;

import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockListActivity;
import com.google.inject.Inject;
import com.itlyceum.npl.R;
import com.itlyceum.npl.model.Drug;
import com.itlyceum.npl.model.Schedule;
import com.itlyceum.npl.storage.DrugStorageInterface;
import com.itlyceum.npl.storage.ScheduleStorageInterface;

import java.util.Date;


public class HomeActivity
    extends RoboSherlockListActivity
{

    @Inject
    ScheduleStorageInterface scheduleStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.home_activity_title);
        Drug drug1 = new Drug();
        drug1.setTitle("Aspirin");

        Schedule schedule1 = new Schedule();
        schedule1.setTitle("For Grandpa");
        schedule1.setDrug(drug1);
        schedule1.setRepeat(Schedule.Repeat.Day);
        schedule1.setStartDate(new Date());
        schedule1.setDescription("Universal drug.jfdksfuaskfbajb");


        Schedule schedule2 = new Schedule();
        schedule2.setTitle("For Uncle");
        schedule2.setDrug(drug1);
        schedule2.setRepeat(Schedule.Repeat.Day);
        schedule2.setStartDate(new Date());
        schedule2.setDescription("Bla bla  blu blyu");


        getListView().setAdapter(new ScheduleListViewAdapter(this, new Schedule[]{schedule1, schedule2}));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add_schedule:
                startActivity(new Intent(this, AddScheduleActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
