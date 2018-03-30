package com.example.priyankam.customagendacalendarview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.priyanka.customcalendarlibrary.AgendaCalendarView;
import com.priyanka.customcalendarlibrary.CalendarManager;
import com.priyanka.customcalendarlibrary.CalendarPickerController;
import com.priyanka.customcalendarlibrary.models.BaseCalendarEvent;
import com.priyanka.customcalendarlibrary.models.CalendarEvent;
import com.priyanka.customcalendarlibrary.models.DayItem;
import com.priyanka.customcalendarlibrary.models.IDayItem;
import com.priyanka.customcalendarlibrary.models.IWeekItem;
import com.priyanka.customcalendarlibrary.models.WeekItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CalendarPickerController {

    AgendaCalendarView mAgendaCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAgendaCalendarView=findViewById(R.id.agenda_calendar_view);

        // minimum and maximum date of our calendar
        // 2 month behind, one year ahead, example: March 2015 <-> May 2015 <-> May 2016
        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        minDate.add(Calendar.MONTH, -2);
        minDate.set(Calendar.DAY_OF_MONTH, 1);
        maxDate.add(Calendar.YEAR, 1);

        List<CalendarEvent> eventList = new ArrayList<>();
        mockList(eventList);

        //////// This can be done once in another thread
        CalendarManager calendarManager = CalendarManager.getInstance(getApplicationContext());
        calendarManager.buildCal(minDate, maxDate, Locale.getDefault(), new DayItem(), new WeekItem());
        calendarManager.loadEvents(eventList, new BaseCalendarEvent());
        ////////

        List<CalendarEvent> readyEvents = calendarManager.getEvents();
        List<IDayItem> readyDays = calendarManager.getDays();
        List<IWeekItem> readyWeeks = calendarManager.getWeeks();
        mAgendaCalendarView.init(Locale.getDefault(), readyWeeks,readyDays,readyEvents,this);
        mAgendaCalendarView.addEventRenderer(new DrawableEventRenderer());
        mAgendaCalendarView.enableCalenderView(true);
    }

    private void mockList(List<CalendarEvent> eventList) {
        Calendar startTime1 = Calendar.getInstance();
        Calendar endTime1 = Calendar.getInstance();
        endTime1.add(Calendar.MONTH, 1);
        BaseCalendarEvent event1 = new BaseCalendarEvent("Thibault travels in Iceland", "A wonderful journey!", "Iceland",
                ContextCompat.getColor(this, R.color.colorPrimary), startTime1, endTime1, true);
        eventList.add(event1);

        Calendar startTime2 = Calendar.getInstance();
        startTime2.add(Calendar.DAY_OF_YEAR, 1);
        Calendar endTime2 = Calendar.getInstance();
        endTime2.add(Calendar.DAY_OF_YEAR, 3);
        BaseCalendarEvent event2 = new BaseCalendarEvent("Visit to Dalvík", "A beautiful small town", "Dalvík",
                ContextCompat.getColor(this, R.color.colorAccent), startTime2, endTime2, true);
        eventList.add(event2);

        Calendar startTime3 = Calendar.getInstance();
        Calendar endTime3 = Calendar.getInstance();
        startTime3.set(Calendar.HOUR_OF_DAY, 14);
        startTime3.set(Calendar.MINUTE, 0);
        endTime3.set(Calendar.HOUR_OF_DAY, 15);
        endTime3.set(Calendar.MINUTE, 0);
        DrawableCalendarEvent event3 = new DrawableCalendarEvent("Visit of Harpa", "", "Dalvík",
                ContextCompat.getColor(this, R.color.colorOrange), startTime3, endTime3, false, android.R.drawable.ic_dialog_info);
        eventList.add(event3);
    }

    @Override
    public void onDaySelected(IDayItem dayItem) {

    }

    @Override
    public void onEventSelected(CalendarEvent event) {

    }

    @Override
    public void onScrollToDate(Calendar calendar) {

    }
}
