package com.sujit.enva2016;

import java.io.Serializable;

/**
 * Created by Rajkumar on 01-10-2016.
 */
public class EventClass implements Serializable {

    int icon;
    String eventName;
    String fee;
    String date;


    public EventClass(int icon, String eventName,String date,String fee) {
        this.icon = icon;
        this.eventName = eventName;
        this.fee = fee;
        this.date = date;

    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getDate() {
        return date;
    }
}
