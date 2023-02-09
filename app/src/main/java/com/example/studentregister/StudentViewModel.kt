package com.example.studentregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregister.db.StudentDao
import com.example.studentregister.db.Studnet
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao) : ViewModel() {
    val students = dao.getAllStudents()

    fun insertStudent(student : Studnet)=viewModelScope.launch {
        dao.insertStudent(student)
    }
    fun updateStudent(student : Studnet)=viewModelScope.launch {
        dao.upadateStudent(student)
    }
    fun deleteStudent(student : Studnet)=viewModelScope.launch {
        dao.deleteStudent(student)
    }

}