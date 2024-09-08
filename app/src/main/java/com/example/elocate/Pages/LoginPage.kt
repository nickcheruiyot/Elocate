package com.example.elocate.Pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elocate.AuthState
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel)
{
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    val authState = authViewModel.authState.bserveAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.Value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context, authState.value.message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }

    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Login Page", fontSize = 32.sp)
        Spacer( modifier = Modifier.height(16.dp))

        OutLinedTextField(
            value = email,
            onValueChange = {
                email =it
            },
            label={
                Text(text= "Email")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutLinedTextField(
            value = password,
            onValueChange = {
                password =it
            },
            label={
                Text(text= "Password")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { authViewModel.login(email.password) },
            enabled = authState.value!= AuthState.Loading) {
            Text = (text = "Login")

        }
        Spacer (modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate("Signup")/*TODO*/ }) {
            Text(text= "Don't have an account, Signup")

        }
    }
}