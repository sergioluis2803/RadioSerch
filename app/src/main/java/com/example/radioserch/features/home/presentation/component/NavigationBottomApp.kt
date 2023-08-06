package com.example.radioserch.features.home.presentation.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.radioserch.features.navigation.util.ItemsMenu

@Composable
fun NavigationBottomApp(
    navController: NavHostController,
    navigationItem: List<ItemsMenu>
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
            val currentRoute = currentRoute(navController = navController)
            navigationItem.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen ->
                                popUpTo(screen) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.title)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = Color.Black,
                        unselectedTextColor = Color.Black
                    )
                )
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val routeIn by navController.currentBackStackEntryAsState()
    return routeIn?.destination?.route
}