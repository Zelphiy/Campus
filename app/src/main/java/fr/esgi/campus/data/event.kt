package fr.esgi.campus.data

import androidx.compose.runtime.Composable

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int
)
