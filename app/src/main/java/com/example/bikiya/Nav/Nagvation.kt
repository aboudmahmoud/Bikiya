package com.example.bikiya.Nav


import androidx.compose.runtime.Composable


import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.navArgument

import com.example.bikiya.Screens.*

@Composable
fun Nagvation(navController: NavHostController) {


    NavHost(navController = navController , startDestination ="MainPage"){
        composable("MainPage"){
             LoginPage(navController= navController)
        }
        composable("OTPPage/{phoneNuber}",  arguments = listOf(navArgument("phoneNuber") { type = NavType.StringType })){

            OTPPage(navController=navController, phonenNimber = it.arguments?.getString("phoneNuber").toString())

        }
        composable("HomePage"){
            HomeScreen(navController=navController)
        }
        composable("itemPage"){
            ItemsPage(navController=navController)
        }

        composable("MapsPagg"){
            MpasPage()
        }

    }

}