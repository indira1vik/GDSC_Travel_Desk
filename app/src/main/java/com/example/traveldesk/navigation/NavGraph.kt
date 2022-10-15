package com.example.traveldesk.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.traveldesk.allscreens.DetailScreen
import com.example.traveldesk.allscreens.HomeScreen
import com.example.traveldesk.allscreens.SplashScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route){
        composable(Screens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screens.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(Screens.DetailScreen.route, arguments = listOf(
            navArgument(CITY_NAME_ARG){
                type = NavType.StringType
            })
        ){each ->
            DetailScreen(navController = navController, each.arguments?.getString("name"))
        }
    }
}