package com.priyanka.customcalendarlibrary.render;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.priyanka.customcalendarlibrary.R;
import com.priyanka.customcalendarlibrary.models.BaseCalendarEvent;

/**
 * Class helping to inflate our default layout in the AgendaAdapter
 */
public class DefaultEventRenderer extends EventRenderer<BaseCalendarEvent> {

    // region class - EventRenderer

    @Override
    public void render(@NonNull View view, @NonNull BaseCalendarEvent event) {
        TextView txtTitle = view.findViewById(R.id.view_agenda_event_title);
        TextView txtLocation = view.findViewById(R.id.view_agenda_event_location);
        LinearLayout descriptionContainer = view.findViewById(R.id.view_agenda_event_description_container);
        LinearLayout locationContainer = view.findViewById(R.id.view_agenda_event_location_container);

        descriptionContainer.setVisibility(View.VISIBLE);
        txtTitle.setTextColor(view.getResources().getColor(android.R.color.black));

        txtTitle.setText(event.getTitle());
        txtLocation.setText(event.getLocation());
        if (event.getLocation().length() > 0) {
            locationContainer.setVisibility(View.VISIBLE);
            txtLocation.setText(event.getLocation());
        } else {
            locationContainer.setVisibility(View.GONE);
        }

        if (event.getTitle().equals(view.getResources().getString(R.string.agenda_event_no_events))) {
            txtTitle.setTextColor(view.getResources().getColor(android.R.color.black));
        } else {
            txtTitle.setTextColor(view.getResources().getColor(R.color.theme_text_icons));
        }
        descriptionContainer.setBackgroundColor(event.getColor());
        txtLocation.setTextColor(view.getResources().getColor(R.color.theme_text_icons));
    }

    @Override
    public int getEventLayout() {
        return R.layout.view_agenda_event;
    }

    // endregion
}
