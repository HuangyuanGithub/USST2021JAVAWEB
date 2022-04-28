package com.usst.MVC.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
    public String changeTime(long time){
        String times= String.valueOf(time);
        Date date= new Date(Long.parseLong(times.trim()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }
}
