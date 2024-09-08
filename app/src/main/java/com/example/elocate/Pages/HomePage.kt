package com.example.elocate.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.elocate.AuthState
import com.example.elocate.AuthViewModel

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel){
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value){
        when(authState.value){
            is AuthState.Unauthenticated ->navController.navigate("login")
            else ->Unit
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Home page", fontSize =32.sp)
        TextButton(onClick = { authViewModel.signOut()})
        {
            Text(text = "Sign out")
        }
    }
}