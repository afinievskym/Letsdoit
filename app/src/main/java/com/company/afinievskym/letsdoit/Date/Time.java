package com.company.afinievskym.letsdoit.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Time {
    private Calendar currenttime = Calendar.getInstance();
    public String GetTime(){
        return " время: " + currenttime.get(Calendar.HOUR) + ":" + currenttime.get(Calendar.MINUTE);
    }
    public String GetDate(){
        return "Дата: " + currenttime.get(Calendar.YEAR) + "/" + (currenttime.get(Calendar.MONTH)+1) + "/" + currenttime.get(Calendar.DATE);
    }
}
