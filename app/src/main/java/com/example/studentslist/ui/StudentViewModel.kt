package com.example.studentslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentslist.data.Student
import com.example.studentslist.data.StudentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class StudentViewModel : ViewModel() {
    private val _students = MutableStateFlow(StudentRepository.getStudents())
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    init {
        loadStudents()
    }

    private fun loadStudents() {
        viewModelScope.launch {
            _students.value = StudentRepository.getStudents() // Ambil data dari repo
        }
    }
}

