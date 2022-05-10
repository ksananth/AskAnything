package com.kraftanapp.askanything.feature.dashboard


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val openDialog = remember { mutableStateOf(false) }

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

    BackHandler(enabled = true) {
        openDialog.value = true
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Logout")
            },
            text = {
                Text("Do you want to logout app?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        sessionApi.logOut()
                        navController.navigateUp()
                    }) {
                    Text("Ok")
                }
            },
            dismissButton = {
                Button(

                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("Cancel")
                }
            }
        )
    }
}


private data class DashboardItem(val id: Int, val name: Int, val navigate: Routes)

private fun navigate(navController: NavHostController, item: DashboardItem) {
    navController.navigate(item.navigate.route)
}
