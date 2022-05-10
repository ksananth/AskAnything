package com.kraftanapp.askanything.feature.transfer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kraftanapp.askanything.Routes

@Composable
fun TransferScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var from by remember { mutableStateOf(TextFieldValue("")) }
        var to by remember { mutableStateOf(TextFieldValue("")) }
        var amount by remember { mutableStateOf(TextFieldValue("")) }
        var communication by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = from,
            onValueChange = {
                from = it
            },
            label = { Text(text = "From") },
            placeholder = { Text(text = "from account") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = to,
            onValueChange = {
                to = it
            },
            label = { Text(text = "To") },
            placeholder = { Text(text = "to account") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = { Text(text = "Amount") },
            placeholder = { Text(text = "Enter amount") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = communication,
            onValueChange = {
                communication = it
            },
            label = { Text(text = "From") },
            placeholder = { Text(text = "Enter communication") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate(Routes.TransferConfirm.route) }) {
            Text(text = "NEXT")
        }
    }
}