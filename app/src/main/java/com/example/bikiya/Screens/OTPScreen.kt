package com.example.bikiya.Screens

import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.*


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bikiya.R
import com.example.bikiya.ui.theme.nearYello
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

@Composable
fun OTPPage(modifier: Modifier=Modifier,navController: NavController,phonenNimber:String="xxxx") {
 Column() {
     Spacer(modifier = modifier.height(15.dp))
     Header(modifier=modifier,navController)
     Column(horizontalAlignment = Alignment.CenterHorizontally) {
         Spacer(modifier = modifier.height(60.dp))
         Text(text = stringResource(id = R.string.weSend), textAlign = TextAlign.Center)
         Spacer(modifier = modifier.height(20.dp))
         Text(text=phonenNimber)
         Spacer(modifier = modifier.height(20.dp))
         Text(text = stringResource(id = R.string.PlaseEanteOp))
         Spacer(modifier = modifier.height(20.dp))
         Row(horizontalArrangement = Arrangement.SpaceBetween){
             OtpChat()
             Spacer(modifier = modifier.width(5.dp))
             OtpChat()
             Spacer(modifier = modifier.width(5.dp))
             OtpChat()
             Spacer(modifier = modifier.width(5.dp))
             OtpChat()
             Spacer(modifier = modifier.width(5.dp))
             OtpChat()
             //....
         }
         Spacer(modifier = modifier.height(20.dp))
         Row(horizontalArrangement = Arrangement.Center) {
             Spacer(modifier = modifier.width(40.dp))
             Button(onClick = {

             },colors = ButtonDefaults.buttonColors(containerColor = nearYello)){
                 Text(text = stringResource(R.string.ResendSM) , style = TextStyle(
                     fontSize = 10.sp
                 ))
             }

             Spacer(modifier = modifier.width(40.dp))

             Button(onClick = {
                 navController.navigate("HomePage")
             }){
                 Text(text = stringResource(R.string.ConfirmOTP),style = TextStyle(
                     fontSize = 10.sp
                 ) )
             }
             Spacer(modifier = modifier.width(40.dp))
         }
     }
 }
}

@Composable
fun Header(modifier: Modifier,navController: NavController) {
    Row(horizontalArrangement =Arrangement.Center) {
        Spacer(modifier =modifier.width(10.dp) )
        Image(painter = painterResource(id = R.drawable.ic_component_2), contentDescription = null,
        modifier=modifier.clickable { navController.navigateUp() })
        Spacer(modifier =modifier.width(15.dp) )
        Text(text = stringResource(id = R.string.OTPV),modifier=modifier.align(CenterVertically))
    }
}

@Composable
fun OtpCell(
    modifier: Modifier,
    value: String,
    isCursorVisible: Boolean = false
) {
    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }

    Box(
        modifier = modifier
    ) {
        Text(
            text = if (isCursorVisible) cursorSymbol else value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Composable
fun PinInput(
    modifier: Modifier = Modifier,
    length: Int = 5,
    value: String = "",
    onValueChanged: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    TextField(
        value = value,
        onValueChange = {
            if (it.length <= length) {
                if (it.all { c -> c in '0'..'9' }) {
                    onValueChanged(it)
                }
                if (it.length >= length) {
                    keyboard?.hide()
                }
            }
        },
        // Hide the text field
        modifier = Modifier
            .size(0.dp)
            .focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(length) {
            OtpCell(
                modifier = modifier
                    .size(width = 45.dp, height = 60.dp)

                    .background(Color.Gray)
                    .clickable {
                        focusRequester.requestFocus()
                        keyboard?.show()
                    },
                value = value.getOrNull(it)?.toString() ?: "",
                isCursorVisible = value.length == it
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}


@Composable
fun OtpChat(){
    var text by remember { mutableStateOf("") }
    val maxChar = 1

    Column(Modifier.background(DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value =text,
            onValueChange = {if (it.length <= maxChar) text = it},
            modifier = Modifier.width(50.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 20.sp,
                textAlign= TextAlign.Center),
            colors= TextFieldDefaults.textFieldColors(
                textColor = White,
                backgroundColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                focusedIndicatorColor = Transparent)
        )
        Divider(Modifier
            .width(28.dp)
            .padding(bottom = 2.dp)
            .offset(y=-10.dp),
            color = White,
            thickness = 1.dp)
    }
}

