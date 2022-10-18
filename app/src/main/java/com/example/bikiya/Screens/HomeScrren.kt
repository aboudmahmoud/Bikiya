package com.example.bikiya.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material.Card

import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bikiya.Pojo.Catgory
import com.example.bikiya.R
import com.example.bikiya.ui.theme.neargreenback

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController) {
    Column(
        modifier
            .fillMaxHeight()
            .padding(10.dp), horizontalAlignment = CenterHorizontally) {
        Spacer(modifier = modifier.height(30.dp))
        Card(modifier = modifier
            .fillMaxWidth()
            .background(color = neargreenback)
            .align(CenterHorizontally)) {
            Column(modifier = modifier.background(color = neargreenback), horizontalAlignment = CenterHorizontally) {
                Spacer(modifier = modifier.height(30.dp))
                Text(text = stringResource(id = R.string.ToadyAffor), style = TextStyle(
                    color = Color.White
                ))

                Spacer(modifier = modifier.height(20.dp))

                Text(text = stringResource(id = R.string.Affor), style = TextStyle(
                    color = Color.White
                ))
                Spacer(modifier = modifier.height(20.dp))

            }
        }
        Spacer(modifier = modifier.height(40.dp))
        ListOfProducte(navController)

        Button( onClick = {

        }){
          Text(text = stringResource(R.string.GetEstimate) )
        }
    }
}

@Composable
fun ListOfProducte(navController:NavController) {
    val catgorrys = listOf(
        Catgory(
            "E-waste",
            "https://www.clearias.com/up/e-waste.png",
            {
                Log.d("aboud", "ListOfProducte: hi hllo")
                navController.navigate("itemPage")
            }
        ), Catgory(
            "Matels",
            "https://news.egyexporter.com/wp-content/uploads/2022/02/ny4mavbUh8k6fpupcYdmg5-1200-80-1.jpg"
            ,
            {
                Log.d("aboud", "ListOfProducte: hi hllo")
                navController.navigate("itemPage")
            }),
        Catgory(
            "Paper",
            "https://i.pinimg.com/originals/a7/b3/67/a7b3672d7fb02bf4b9dceb39a63682b3.jpg"
            ,
            {
                Log.d("aboud", "ListOfProducte: hi hllo")
                navController.navigate("itemPage")
            } ),
        Catgory(
            "plastic",
            "https://media.istockphoto.com/vectors/nonbiodegradable-product-vector-id972767246?k=20&m=972767246&s=612x612&w=0&h=0p2-OkxrlJAe71Cxdleiqq9kgmypz2XGm-yNGRhlRFM="
            ,
            {
                Log.d("aboud", "ListOfProducte: hi hllo")
                navController.navigate("itemPage")
            }  )

    )

    LazyColumn( contentPadding = PaddingValues(16.dp)) {

        val itemCount = if (catgorrys.size % 2 == 0) {
            catgorrys.size / 2
        } else {
            catgorrys.size / 2 + 1
        }
        items(itemCount) {
            rowdix(catgorrys,it)
        }

    }



}



@Composable
fun rowdix(catgory: List<Catgory>, Number: Int = 0) {

    Column (){
        Row  ( ) {
            ProducteDisplay(
                catgory[Number * 2],

                )
            Spacer(modifier = Modifier.width(35.dp))
            if (catgory.size >= Number * 2 + 2) {
                ProducteDisplay(
                    catgory[Number * 2 + 1],

                    )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }


}

@Composable
fun ProducteDisplay(
    catgory: Catgory,
    modifier: Modifier = Modifier
) {

    Column(modifier.clickable( onClick = catgory.Action)) {
        Image(
            painter = rememberAsyncImagePainter(catgory.CatgorImage),
            contentDescription = "serch", modifier = modifier
                .width(100.dp)
                .height(100.dp)
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(text = catgory.CatgoryType,modifier=Modifier.align(CenterHorizontally))
    }
}