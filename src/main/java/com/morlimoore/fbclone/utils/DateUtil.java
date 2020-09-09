package com.morlimoore.fbclone.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This function provides the current time of the day in an SQL compatible format
 */
public class DateUtil {

    public static String getCurrentDate() {
        //Translates the current date to an SQL compatible format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        return currentDate;
    }
}
