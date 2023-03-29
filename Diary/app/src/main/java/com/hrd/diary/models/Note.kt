package com.hrd.diary.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    val title: String,
    val content: String,

    @PrimaryKey(autoGenerate = true) val id: Long=0L,
)
