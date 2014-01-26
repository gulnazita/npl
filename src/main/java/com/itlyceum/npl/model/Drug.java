package com.itlyceum.npl.model;

/**
 * Author: Gulnaz Sibgatullina
 * Date: 26.01.14.
 */
public class Drug {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId(){
        return this.hashCode();
    }
}
