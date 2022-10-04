package com.example.drawermenu

import android.graphics.Color
import com.example.drawermenu.model.MenuItem
import com.example.drawermenu.model.TypeItem

class Items {

    companion object Items {
        val listOfItems = mutableListOf(
            MenuItem(
                title = "Dashboard",
                icon = R.drawable.ic_baseline_space_dashboard_24,
                type = Types.BUSINESS.name),
            MenuItem(
                title = "Profile",
                icon = R.drawable.ic_baseline_account_circle_24,
                notification_number = 1,
                notification_color = Color.DKGRAY,
                type = Types.BUSINESS.name),
            MenuItem(
                title = "Notification",
                icon = R.drawable.ic_baseline_notifications_active_24,
                notification_number = 4,
                notification_color = Color.BLUE,
                type = Types.BUSINESS.name),
            MenuItem(
                title = "Calendar",
                icon = R.drawable.ic_baseline_calendar_month_24,
                type = Types.BUSINESS.name),
            MenuItem(
                title = "Settings",
                icon = R.drawable.ic_baseline_settings_24,
                type = Types.BUSINESS.name),
            MenuItem(
                title = "Profile",
                icon = R.drawable.ic_baseline_account_circle_24,
                notification_color = Color.DKGRAY,
                type = Types.PERSONAL.name),
            MenuItem(
                title = "Notification",
                icon = R.drawable.ic_baseline_notifications_active_24,
                notification_number = 3,
                notification_color = Color.BLUE,
                type = Types.PERSONAL.name),
            MenuItem(
                title = "Notes",
                icon = R.drawable.ic_baseline_speaker_notes_24,
                notification_number = 1,
                notification_color = Color.MAGENTA,
                type = Types.PERSONAL.name),

        )

        val listOfTypes = mutableListOf<TypeItem>(
            TypeItem(type = "PERSONAL"),
            TypeItem(type = "BUSINESS")
        )
        var filteredListOfItems = mutableListOf<MenuItem>()

    }

    enum class Types {
        BUSINESS,
        PERSONAL
    }
}


