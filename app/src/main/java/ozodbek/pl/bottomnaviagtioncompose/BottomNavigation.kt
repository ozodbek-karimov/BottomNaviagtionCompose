package ozodbek.pl.bottomnaviagtioncompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


/**
 *@Creator: Ozodbek Karimov
 *@Date: 08/08/2024
 *@File: BottomNavigation.java
 */


enum class BottomNavigation(val label: String, val icon: ImageVector, val route: Destinations) {
    HOME("Home", Icons.Filled.Home, Destinations.Home),
    SEARCH("Search", Icons.Filled.Search, Destinations.Search()),
    PROFILE("Profile", Icons.Filled.AccountCircle, Destinations.Profile);
}
