package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infinitelearning.infiniteapp.Navigation.NavigationItem
import com.infinitelearning.infiniteapp.Navigation.Screen
import com.infinitelearning.infiniteapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route?:
        Screen.Home.route
    val currentScreen = remember(currentRoute) {
        Screen.fromRoute(currentRoute)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {  navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = stringResource(id = R.string.menu_back)
                        )
                    }
                },
                title = { Text(text = currentScreen.title) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF6F5F2),
                ),
            )
        },
            bottomBar = {
                BottomBar(navController)
            },
            modifier = modifier
            ) { contentPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = modifier.padding(contentPadding)
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Screen.Explore.route) {
                        ExploreScreen()
                    }
                    composable(Screen.About.route) {
                        AboutMeScreen(navController)
                    }
                    composable(Screen.Detail.route+"/{detailsId}",
                        arguments = listOf(navArgument("detailsId"){type = NavType.IntType}))
                    {navBackStackEntry ->
                        DetailScreen(
                            modifier = modifier, navController = navController,
                            detailsId = navBackStackEntry.arguments?.getInt("detailsId")
                        )
                    }
                }
            }
        }

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar (
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_explore),
                icon = Icons.Default.Search,
                screen = Screen.Explore
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Person,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon , contentDescription = item.title ) },
                label = { Text(text = item.title) }
            )
        }
    }
}
