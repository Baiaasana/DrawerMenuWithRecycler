package com.example.drawermenu.model

import android.graphics.Color
import java.util.*

data class TypeItem(
    val id: String = UUID.randomUUID().toString(),
    val type: String?,
    val background_color: Int? = Color.BLUE
)