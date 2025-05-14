package com.demo.navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.demo.navigation.RegistrationInfo

@Composable
fun Registration(onNavigateForward: (info: RegistrationInfo) -> Unit) {

    var name by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var mobile by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = name, onValueChange = { name = it } , placeholder = { Text("Enter Name") })
        TextField(value = age, onValueChange = { age = it }, placeholder = { Text("Enter Age") })
        TextField(value = mobile, onValueChange = { mobile = it } , placeholder = { Text("Enter Mobile") })
        Button(onClick = {
            onNavigateForward(RegistrationInfo(name, mobile, age))
        }) {
            Text("Submit")
        }
    }

}