package com.kraftanapp.askanything.feature.dashboard


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
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
import com.kraftanapp.askanything.Routes
import com.kraftanapp.askanything.SessionRepository
import org.koin.androidx.compose.get

private const val TRANSFER = 1
private const val STO = 2
private const val DD = 3
private const val CARDS = 4
private const val BENEFICIARY = 5
private const val CONTACT = 6

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    val sessionApi = get<SessionRepository>()
    sessionApi.isLoggedIn
    val data: List<DashboardItem> = arrayListOf(
        DashboardItem(TRANSFER, R.string.transfer, Routes.Transfer),
        DashboardItem(STO, R.string.sto, Routes.StandingOrder),
        DashboardItem(DD, R.string.dd, Routes.DirectDebit),
        DashboardItem(CARDS, R.string.cards, Routes.Cards),
        DashboardItem(BENEFICIARY, R.string.beneficiary, Routes.Beneficiary),
        DashboardItem(CONTACT, R.string.contact, Routes.Contact)
    )
    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data.size) { item ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                onClick = {
                    navigate(navController, data[item])
                },
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = stringResource(id = data[item].name),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

private data class DashboardItem(val id: Int, val name: Int, val navigate: Routes)

private fun navigate(navController: NavHostController, item: DashboardItem) {
    navController.navigate(item.navigate.route)
}
