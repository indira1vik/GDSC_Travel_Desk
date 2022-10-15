package com.example.traveldesk.allscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.traveldesk.R
import com.example.traveldesk.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(2000L)
        navController.popBackStack()
        navController.navigate(Screens.HomeScreen.route)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        //alignment = anchor to some component
        horizontalAlignment = Alignment.CenterHorizontally,
        //arrangement = relative to some component
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Rounded.Star,
            contentDescription = "app_icon",
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(text = "Let's Explore")
    }
}

@Preview
@Composable
fun PrevSplash(){
    SplashScreen(navController = rememberNavController())
}