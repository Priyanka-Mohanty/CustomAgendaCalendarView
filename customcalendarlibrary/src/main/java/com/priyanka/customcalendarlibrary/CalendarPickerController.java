package com.priyanka.customcalendarlibrary;

import com.priyanka.customcalendarlibrary.models.CalendarEvent;
import com.priyanka.customcalendarlibrary.models.IDayItem;

import java.util.Calendar;

public interface CalendarPickerController {

    void onDaySelected(IDayItem dayItem);

    void onEventSelected(CalendarEvent event);

    void onScrollToDate(Calendar calendar);
}
