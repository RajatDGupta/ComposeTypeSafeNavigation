package com.demo.navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.demo.navigation.RegistrationInfo

@Composable
fun RegistrationDetail(info: RegistrationInfo, onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        info.name?.let { Text(it) }
        info.age?.let { Text(it) }
        info.mobileNo?.let { Text(it) }
        Button(onClick = {
            onNavigateBack()
        }) {
            Text("Back")
        }
    }
}