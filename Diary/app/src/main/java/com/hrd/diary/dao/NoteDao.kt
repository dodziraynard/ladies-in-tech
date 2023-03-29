package com.hrd.diary.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hrd.diary.models.Note


@Dao
interface NoteDao {

    @Insert()
    fun insertNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>
}