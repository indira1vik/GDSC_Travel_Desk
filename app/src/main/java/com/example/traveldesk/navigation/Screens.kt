package com.example.traveldesk.navigation

const val CITY_NAME_ARG = "name"

sealed class Screens(val route: String){
    object HomeScreen: Screens("home_screen")
    object SplashScreen: Screens("splash_screen")
    object DetailScreen: Screens("detail_screen/{$CITY_NAME_ARG}"){
        fun PassName(city_name: String):String{
            return "detail_screen/$city_name"
        }
    }
}