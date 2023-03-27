package com.example.habitapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
THIS SPLASHSCREEN FUNCTION CAN BE USED IN THE MAIN COMPOSABLE FUNCTION WHERE YOU WANT TO
DISPLAY IT BY CALLING THE FUNCTION AS USUAL.

SplashScreen()

 */

@Composable
fun SplashScreen(){

    //using 'Box' and 'Column' composable functions to align the content in the center of the screen.
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize())
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally)

        {
            //using 'Image' and 'Text' composable functions to display desired image and text.
            //'loading_icon' and 'Loading...' are place holders for the time being but
            // can be changed to be anything we want.
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Logo Icon",
                tint = Color.White
            )
            /*USE THIS IF WE WANT OUR OWN LOGO
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null)
            */
            Text(
                text = "Loading...",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

}
