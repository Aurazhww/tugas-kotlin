package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.infiniteapp.Navigation.NavigationItem
import com.infinitelearning.infiniteapp.Navigation.Screen
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Cinema
import com.infinitelearning.infiniteapp.model.TopCinema
import com.infinitelearning.infiniteapp.presentation.component.CinemaItem
import com.infinitelearning.infiniteapp.presentation.component.TopCinemaItem

@Composable
fun HomeScreen(
    navController: NavController,
    cinemas: List<Cinema> = DummyData.posterCinema,
    topitems: List<TopCinema> = DummyData.filmKorea,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .verticalScroll(rememberScrollState())
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(1.dp),
                    modifier = modifier
                ) {
                    items(cinemas, key = { it.id }) {
                        CinemaItem(cinema = it, modifier = Modifier) {detailsId -> navController.navigate(Screen.Detail.route+"/$detailsId")}
                    }
                }
                Text(
                    text = "Top 10 Korean Movies",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    userScrollEnabled = false,
                    modifier = modifier
                        .height(800.dp)
                ) {
                    items(topitems, key = { it.id }) {
                        TopCinemaItem(top = it, modifier = Modifier.padding(horizontal = 5.dp)) }
                }
            }
        }



