package com.itlyceum.npl.model;

import java.util.Date;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class Schedule {
    private String title;
    private Drug drug;
    private Date startDate;
    private Repeat repeat;
    private String description;

    public int getId(){
        return this.hashCode();
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
      this.title = title;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public void setRepeat(Repeat repeat) {
        this.repeat = repeat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Repeat{
        Hour,
        Day,
        Week,
        Month;

        private Date endDate;

        public void setEndDate(Date date){
            endDate = date;
        }
    }
}
