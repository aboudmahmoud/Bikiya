

package com.example.bikiya.Screens


import android.content.Context

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center

import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bikiya.Pojo.items
import com.example.bikiya.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi


lateinit var navControllera:NavController
lateinit var context:Context
@Composable
fun ItemsPage(navController: NavController){
    navControllera=navController;
     context = LocalContext.current

    ListOfitems()

}
@Composable
fun ListOfitems() {
    val itemsList = listOf(
        items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        ), items(
            "Plastic", "Plastics are a wide range " +
                    "of synthetic or semi-synthetic materials that use polymers as a main ingredient. " +
                    "Their plasticity makes it possible for plastics to be moulded, extruded or pressed into solid objects of various shapes.",
            "https://m.media-amazon.com/images/I/51SblzkSAIL._AC_SL1500_.jpg"
        )
    )


    LazyColumn( contentPadding = PaddingValues(16.dp)) {
      items(itemsList){
          ItemsBox(it)
      }

    }
}

@Composable
fun ItemsBox(Items: items) {
    Box() {
        Row(

        ) {
            ItemAndDiscreption(Items)
            ImageItemsAddes(Items, modifier = Modifier.align(CenterVertically))
        }
    }
}
@Composable
fun ItemAndDiscreption(Items: items,modifier: Modifier=Modifier) {
    Box(
        modifier
            .width(250.dp)
            .padding(40.dp)){
        Column() {
            Text(text =Items.ItemName)
            Text(text =Items.ItemDescarptaion)
        }
    }
}





@Composable
fun ImageItemsAddes(Items: items,modifier:Modifier=Modifier) {
    Box(modifier.fillMaxSize(),contentAlignment = Center) {
        Column(verticalArrangement=Arrangement.Center,) {
            Image(
                painter = rememberAsyncImagePainter(Items.itemImage),
                contentDescription = "serch", modifier = modifier
                    .align(CenterHorizontally)
                    .width(100.dp)
                    .height(100.dp)
            )
            Spacer(modifier = modifier.height(10.dp))
            Card(elevation = 10.dp,border = BorderStroke(1.dp, Color.Black), modifier = modifier.clickable{

                navControllera.navigate("MapsPagg")

            }) {
                Text(text = stringResource(R.string.add),modifier= modifier
                    .align(CenterHorizontally)
                    .padding(5.dp))
            }

        }
    }
}

