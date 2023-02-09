package com.example.studentregister.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(studnet: Studnet)

    @Update
    suspend fun upadateStudent(studnet: Studnet)

    @Delete
    suspend fun deleteStudent(studnet: Studnet)

    @Query("SELECT * FROM student_datatable")
    fun getAllStudents() : LiveData<List<Studnet>>


}