package com.priyanka.customcalendarlibrary.models;

import android.support.annotation.Nullable;

import java.util.Calendar;

public interface CalendarEvent {

    boolean isPlaceholder();

    void setPlaceholder(boolean placeholder);

    String getLocation();

    void setLocation(String mLocation);

    long getId();

    void setId(long mId);

    Calendar getStartTime();

    void setStartTime(Calendar mStartTime);

    Calendar getEndTime();

    void setEndTime(Calendar mEndTime);

    String getTitle();

    void setTitle(String mTitle);

    Calendar getInstanceDay();

    void setInstanceDay(Calendar mInstanceDay);

    IDayItem getDayReference();

    void setDayReference(IDayItem mDayReference);

    IWeekItem getWeekReference();

    void setWeekReference(IWeekItem mWeekReference);

    boolean hasEvent();

    @Nullable
    Object getEvent();

    void setEvent(@Nullable Object var1);

    CalendarEvent copy();
}
