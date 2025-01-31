package com.example.studentslist.ui

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.studentslist.data.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {


    private val _loginState = MutableStateFlow<Resource<String>>(Resource.Idle)
    val loginState: StateFlow<Resource<String>> = _loginState

     var passwordVisible by mutableStateOf(false)
        private set

    fun togglePasswordVisibility() {
        passwordVisible = !passwordVisible
    }
    fun validateLogin(username: String, password: String, navController: NavController): String {
        viewModelScope.launch {
            _loginState.value = Resource.Loading
            if (username.isEmpty() || password.isEmpty()) {
                _loginState.value = Resource.Error("Username and password are required")
                return@launch
            }
            if (username != "alfagift-admin" || password != "asdf") {
                _loginState.value = Resource.Error("Invalid username or password")
                return@launch
            }
            _loginState.value = Resource.Success("Login successful")
            loginSuccessful(navController)
//            _isLoading.value = false

        }

        return ""
    }

    private fun loginSuccessful(navController: NavController) {
        Toast.makeText(navController.context, "Login successful", Toast.LENGTH_SHORT).show()
        navController.navigate("studentsListScreen")
    }

    fun resetState() {
        _loginState.value = Resource.Idle
    }
}