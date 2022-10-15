package com.example.traveldesk.allscreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.traveldesk.PlaceRepository
import com.example.traveldesk.R

@Composable
fun DetailScreen(navController: NavController, name: String?){
   Scaffold(
       topBar = { MyTopDetail(navController, name) },
       content = { MyDetailContent() }
   )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyDetailContent() {
    val getData = PlaceRepository().getAllData()
    LazyVerticalGrid(
        modifier = Modifier.padding(10.dp),
        cells = GridCells.Fixed(3),
        content = {
            items(getData){item ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = 7.dp,
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 7.dp, 7.dp)
                ) {
                    Image(
                        painter = painterResource(item.aImageRes),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(120.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    )
}

@Composable
fun MyTopDetail(navController: NavController, name: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "back",
            modifier = Modifier.clickable { navController.popBackStack() }
                .size(40.dp)
        )
        Text(
            text = name!!,
            modifier = Modifier.padding(10.dp)
        )
    }
}