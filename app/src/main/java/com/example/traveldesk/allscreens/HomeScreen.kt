package com.example.traveldesk.allscreens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.traveldesk.PlaceRepository
import com.example.traveldesk.R
import com.example.traveldesk.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = { MyTopBar() },
        content = { MyContent(navController) }
    )
}

@Composable
fun MyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        Text(text = "Recommended")
        Recommended(navController)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Popular Cities")
        PopularCities(navController)
    }
}

@Composable
fun PopularCities(navController: NavController) {
    val getData = PlaceRepository().getAllData()
    Column {
        for (i in getData){
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = 7.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 7.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { navController.navigate("detail_screen/${i.CityName}") }
                ) {
                    Image(
                        painter = painterResource(i.aImageRes),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = i.CityName,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Recommended(navController: NavController){
    val getData = PlaceRepository().getAllData()
    LazyRow{
        items(getData){item ->
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = 7.dp,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 15.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(item.aImageRes),
                    contentDescription = "image",
                    modifier = Modifier
                        .clickable { navController.navigate("detail_screen/${item.CityName}") }
                        .size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = item.CityName,
                    modifier = Modifier
                        .padding(5.dp)
                        .shadow(15.dp, RectangleShape),
                    style = TextStyle(color = Color.Gray)
                )
            }
        }
    }
}

@Composable
fun MyTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(Icons.Default.LocationOn, contentDescription = "location")
        Text(text = "Chennai, India")
    }
}

@Preview
@Composable
fun PrevHome(){
    //HomeScreen(navController = rememberNavController())
    //MyTopBar()
    //Recommended(rememberNavController())
    PopularCities(rememberNavController())
}