package com.example.drawermenu.model

import android.graphics.Color
import com.example.drawermenu.R
import java.util.*

data class MenuItem(
    val id: String? = UUID.randomUUID().toString(),
    val title: String? = null,
    val icon: Int? = R.drawable.ic_baseline_360_24,
    val notification_number: Int? = null,
    val notification_color: Int? = Color.WHITE,
    val type: String?,
)