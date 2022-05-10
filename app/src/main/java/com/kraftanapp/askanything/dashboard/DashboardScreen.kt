package com.kraftanapp.askanything.dashboard


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kraftanapp.askanything.R
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    val data: List<Int> = arrayListOf(
        R.string.transfer,
        R.string.sto,
        R.string.dd,
        R.string.cards,
        R.string.beneficiary,
        R.string.contact
    )
    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data.size) { item ->
            Card(
                modifier = Modifier.padding(4.dp),
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = stringResource(id = data[item]),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
