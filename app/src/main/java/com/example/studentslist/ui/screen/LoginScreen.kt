package com.example.studentslist.ui.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentslist.R
import com.example.studentslist.data.Resource
import com.example.studentslist.ui.LoginViewModel
import com.example.studentslist.ui.components.InputField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: LoginViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val loginState by viewModel.loginState.collectAsState()
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
                .windowInsetsPadding(WindowInsets.systemBars),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = "App Logo",
                modifier = Modifier.size(250.dp)
                    .padding(8.dp)
                    .navigationBarsPadding()
            )
            Card(
                Modifier
                    .padding(bottom = 50.dp)
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.green))
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(22.dp),

                ) {
                    Text(text = "Hello!", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 40.sp)
                    Text(text = "Welcome Back", color = Color.White.copy(0.4f), fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    InputField(value = username, onValueChange = { username = it }, label = "Your Username")
                    Spacer(modifier = Modifier.height(12.dp))
                    InputField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        isPassword = true,
                        passwordVisible = viewModel.passwordVisible,
                        onPasswordToggle = { viewModel.togglePasswordVisibility() }
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable {
                                Toast.makeText(context,
                                    "Feature not available yet",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                        color = Color.White,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(26.dp))
                    Button(
                        onClick = {
                            errorMessage = viewModel.validateLogin(username, password, navController)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.black),
                            contentColor = Color.White

                        ),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                            Text("Login", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }

                    if (errorMessage.isNotEmpty()) {
                        Text(text = errorMessage, color = Color.Red)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Or",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        IconButton(onClick = {  Toast.makeText(context,
                            "Feature not available yet",
                            Toast.LENGTH_SHORT
                        ).show() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_google),
                                contentDescription = "Login with Google",
                                modifier = Modifier.size(32.dp),
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = {
                            Toast.makeText(context,
                                "Feature not available yet",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_facebook),
                                contentDescription = "Login with Instagram",
                                modifier = Modifier.size(32.dp),
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
            when (loginState) {
                is Resource.Loading -> {
                    CircularProgressIndicator()
                } is Resource.Success -> {
                navController.navigate("StudentsListScreen")
            }
                is Resource.Error -> {
                    Toast.makeText(LocalContext.current, (loginState as Resource.Error).message, Toast.LENGTH_SHORT).show()
                    viewModel.resetState()
                } is Resource.Idle -> {}
            }
        }

    }
}






@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(NavController(LocalContext.current))
}




