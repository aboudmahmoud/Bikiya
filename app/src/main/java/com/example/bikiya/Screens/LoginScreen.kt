package com.example.bikiya.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bikiya.R
import com.togitech.ccp.component.TogiCountryCodePicker
import com.togitech.ccp.component.TogiRoundedPicker
import com.togitech.ccp.data.utils.checkPhoneNumber
import com.togitech.ccp.data.utils.getDefaultLangCode
import com.togitech.ccp.data.utils.getDefaultPhoneCode
import com.togitech.ccp.data.utils.getLibCountries

@Composable
fun LoginPage(modifier:Modifier=Modifier,navController: NavController) {
    Column( horizontalAlignment = CenterHorizontally) {
        Spacer(modifier = modifier.height(30.dp))

        LogoApp(modifier)
        Spacer(modifier = modifier.height(10.dp))
        PhoneEntarStep(modifier=modifier,navController)
        Spacer(modifier = modifier.height(10.dp))
        Image(painter = painterResource(id = R.drawable.ic_orselection), contentDescription =null )
        Spacer(modifier = modifier.height(10.dp))
        SignWithOnthoerWay(modifier)
    }
}

@Composable
fun LogoApp( modifier:Modifier) {
    Column(modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally ){
      val LogoImage: Painter = painterResource(id = R.drawable.mylogo)
      val Silgon: Painter = painterResource(id = R.drawable.ic_bikiya)
      val SigleonMessage=stringResource(R.string.Signleton)
      Image(painter = LogoImage, modifier = modifier.width(120.dp).height(120.dp)
          , contentScale = ContentScale.Fit, contentDescription = "The Logo Of Great App" ,)
      Spacer(modifier = modifier.height(20.dp))
      Image(painter = Silgon, contentDescription = "The sligon Of Great App" )
      Spacer(modifier = modifier.height(30.dp))
      Text(text =SigleonMessage,style  = TextStyle(color = Color.Black, fontSize = 22.sp,textAlign= TextAlign.Center, fontWeight = FontWeight.Bold))
  }
}

@Composable
fun PhoneEntarStep(modifier:Modifier,navController: NavController) {
    val context = LocalContext.current
    var phoneCode by rememberSaveable { mutableStateOf(getDefaultPhoneCode(context)) }
    var defaultLang by rememberSaveable { mutableStateOf(getDefaultLangCode(context)) }
    var phoneNumber  by rememberSaveable { mutableStateOf("") }
    var isValidPhone by remember { mutableStateOf(true) }
    var verifyText by remember { mutableStateOf("") }

    Column(modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally){

        Text(text= stringResource(R.string.LoginOrSignUp))

        val context = LocalContext.current
        var phoneCode by rememberSaveable { mutableStateOf(getDefaultPhoneCode(context)) }
        var defaultLang by rememberSaveable { mutableStateOf(getDefaultLangCode(context)) }
        var phoneNumber by rememberSaveable { mutableStateOf("") }
        var isValidPhone by remember { mutableStateOf(true) }

        TogiRoundedPicker(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            defaultCountry = getLibCountries().single { it.countryCode == defaultLang },
            pickedCountry = {
                phoneCode = it.countryPhoneCode
                defaultLang = it.countryCode
            },
            error = isValidPhone,
            color = MaterialTheme.colorScheme.surface
        )

        val fullPhoneNumber = "$phoneCode${phoneNumber}"
        val checkPhoneNumber = checkPhoneNumber(
            phone = phoneNumber,
            fullPhoneNumber = fullPhoneNumber,
            countryCode = defaultLang
        )
        Spacer(modifier = modifier.height(20.dp))

        Button(onClick = {
            if(phoneNumber.equals(""))
            {
                phoneNumber="X"
            }else
            navController.navigate("OTPPage/${phoneNumber}")
        },Modifier.fillMaxWidth().padding(10.dp)){
            Text(text = stringResource(R.string.Continue) )
        }
    }
}




@Composable
fun SignWithOnthoerWay(modifier:Modifier) {
    Column(horizontalAlignment = CenterHorizontally) {
     Row() {

         Image(painter =  painterResource(id = R.drawable.ic_google),contentDescription = null, modifier = modifier.height(40.dp))
         Spacer(modifier =modifier.width(20.dp) )

         Image(painter =  painterResource(id = R.drawable.ic_other),contentDescription = null ,modifier = modifier.height(40.dp))

     }
        Spacer(modifier = modifier.height(10.dp))
        Text(text = stringResource(id = R.string.agremmentMessage)
            , style = TextStyle(fontSize = 8.sp), modifier = modifier.padding(10.dp).align(alignment=CenterHorizontally))
    }
}