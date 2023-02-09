package com.example.studentregister.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Studnet:: class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studnetDao() : StudentDao
    companion object{
        @Volatile
        private var INSTANCE : StudentDatabase? = null
        fun getInstance(contex : Context) : StudentDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        contex.applicationContext,
                        StudentDatabase :: class.java,
                        "student_database",
                    ).build()
                }
                return instance
            }
        }
    }
}