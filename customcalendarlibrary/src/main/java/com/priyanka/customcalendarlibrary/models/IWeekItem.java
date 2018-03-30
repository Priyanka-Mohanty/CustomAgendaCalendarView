package com.priyanka.customcalendarlibrary.models;

import java.util.Date;
import java.util.List;

public interface IWeekItem {


    int getWeekInYear();

    void setWeekInYear(int weekInYear);

    int getYear();

    void setYear(int year);

    int getMonth();

    void setMonth(int month);

    Date getDate();

    void setDate(Date date);

    String getLabel();

    void setLabel(String label);

    List<IDayItem> getDayItems();

    void setDayItems(List<IDayItem> dayItems);


    boolean hasEvents();

    void setHasEvents(boolean var1);

    IWeekItem copy();
}
