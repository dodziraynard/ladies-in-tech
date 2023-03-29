package com.hrd.diary

import android.app.Application
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.hrd.diary.dao.NoteDao
import com.hrd.diary.models.Note
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(
    entities = [Note::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    val databaseWriteExecutor: ExecutorService = Executors.newFixedThreadPool(1)

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Application): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(RoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "RoomDatabase"
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
