package com.example.studentslist.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.studentslist.R


@Composable
fun SearchBar(searchText: String, onSearchTextChange: (String) -> Unit) {
    val containerColor = Color.Black.copy(0.1f)

    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        singleLine = true,
        maxLines = 1,
        placeholder = { Text("Search Students") },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
            )
        },
        trailingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_filter),
                contentDescription = "Filter Icon",
            )
        },
        shape = RoundedCornerShape(18.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        )
    )
}
