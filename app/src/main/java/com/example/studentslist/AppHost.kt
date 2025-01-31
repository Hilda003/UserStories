package com.example.studentslist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentslist.ui.screen.LoginScreen
import com.example.studentslist.ui.screen.StudentListScreen


@Composable
fun AppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginScreen(navController = navController)
        }
        composable("studentsListScreen") {
            StudentListScreen()
        }
    }


}