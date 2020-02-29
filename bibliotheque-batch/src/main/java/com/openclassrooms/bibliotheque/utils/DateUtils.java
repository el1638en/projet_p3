package com.openclassrooms.bibliotheque.utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private final static String PATTERN = "dd/MM/yyyy";

    public static String formatDate(XMLGregorianCalendar xmlGregorianCalendar) {
        Date date = xmlGregorianCalendar.toGregorianCalendar().getTime();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern(PATTERN));
    }
}
