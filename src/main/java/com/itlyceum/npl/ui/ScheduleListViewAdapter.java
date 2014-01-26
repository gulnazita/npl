package com.itlyceum.npl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.itlyceum.npl.R;
import com.itlyceum.npl.model.Schedule;

import java.util.List;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class ScheduleListViewAdapter extends BaseAdapter{
    protected Schedule[] scheduleList;
    protected LayoutInflater inflater;

    public ScheduleListViewAdapter(Context context, Schedule[] schedules) {
        scheduleList = schedules;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return scheduleList.length;
    }

    @Override
    public Object getItem(int i) {
        return scheduleList[i];
}

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Schedule schedule = scheduleList[position];
        view = inflater.inflate(R.layout.lv_schedule_item, null);
        ((TextView)view.findViewById(R.id.schedule_title)).setText(schedule.getTitle());
        ((TextView)view.findViewById(R.id.schedule_drug)).setText(schedule.getDrug().getTitle());
        ((TextView)view.findViewById(R.id.schedule_time)).setText(String.format("%te %<ta %<tR", schedule.getStartDate()));
        ((TextView)view.findViewById(R.id.schedule_description)).setText(schedule.getDescription());


        return view;
    }
}
