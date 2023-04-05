package com.example.habitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habitapp.ui.theme.HabitAppTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Shapes
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val habitViewModel: HabitViewModel = viewModel()
            HabitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Display the splash screen
                    SplashScreen()

                    //start a LaunchEffect to delay showing the main screen
                    LaunchedEffect(Unit){
                        delay(2500) //adjust duration as needed
                        setContent{
                            //show the main screen after delay
                            HabitScreen(modifier = Modifier, habitViewModel)
                        }
                    }
                }
            }
        }
    }
}

