package ozodbek.pl.bottomnaviagtioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ozodbek.pl.bottomnaviagtioncompose.screens.HomeScreen
import ozodbek.pl.bottomnaviagtioncompose.screens.ProfileScreen
import ozodbek.pl.bottomnaviagtioncompose.screens.SearchScreen
import ozodbek.pl.bottomnaviagtioncompose.ui.theme.BottomNaviagtionComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNaviagtionComposeTheme {

                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                Scaffold(
                    bottomBar = {
                        BottomAppBar {
                            BottomNavigation.entries
                                .forEachIndexed { index, navigationItem ->
                                    val isSelected by remember(currentRoute) {
                                        derivedStateOf { currentRoute == navigationItem.route::class.qualifiedName }
                                    }

                                    NavigationBarItem(
                                        selected = isSelected,
                                        onClick = { navController.navigate(navigationItem.route) },
                                        icon = {
                                            Icon(
                                                navigationItem.icon,
                                                contentDescription = navigationItem.label
                                            )
                                        })
                                }
                        }
                    }
                ) {
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        navController = navController,
                        startDestination = Destinations.HomeGraph
                    ){
                        navigation<Destinations.HomeGraph>(
                            startDestination = Destinations.Home
                        ){
                            composable<Destinations.Home> {
                                HomeScreen()
                            }
                            composable<Destinations.Search> {
                                SearchScreen(searchText = "")
                            }
                            composable<Destinations.Profile> {
                                ProfileScreen()
                            }
                        }
                    }

                }

            }
        }
    }
}
