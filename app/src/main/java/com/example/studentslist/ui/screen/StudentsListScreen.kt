package com.example.studentslist.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentslist.R
import com.example.studentslist.data.Student
import com.example.studentslist.ui.StudentViewModel
import com.example.studentslist.ui.components.ItemStudent

@Composable
fun StudentListScreen(viewModel: StudentViewModel = viewModel()) {
    var searchText by remember { mutableStateOf("") }
    val students by viewModel.students.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {

        Text(
            text = "Students List",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.green),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        com.example.studentslist.ui.components.SearchBar(
            searchText = searchText,
            onSearchTextChange = {
                searchText = it
            }
        )

        Spacer(modifier = Modifier.height(26.dp))

        StudentList(students)
    }

}



@Composable
fun StudentList(students: List<Student>) {
    LazyColumn {
        items(students) { student ->
            ItemStudent(student)
        }
    }
}
