package com.example.elocate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel:AuthViewModel) {
    val navController = rememberNavController()
    NavHost( navController =navController, startDestination = "login", builder ={
        composable("login"){
            LoginPage( modifier, navController, authViewModel)
        }
        composable("signup"){
            SignupPage( modifier, navController, authViewModel)
        }
        composable("home"){
            HomePage( modifier, navController, AuthViewModel)
        }
    })

}