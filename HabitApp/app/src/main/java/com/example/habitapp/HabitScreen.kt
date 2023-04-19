package com.example.habitapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen


@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel
) {
    // Define the text to be displayed in the action bar
    val title = "Partum-Habitum"

    //This is how data is moved between composable functions and database.
    val habitList by habitViewModel.allHabits.observeAsState()

    //used to capture text from TextField.
    var text by remember { mutableStateOf(TextFieldValue("")) }

    // Add the TopAppBar composable to create the action bar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 4.dp
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            habitList?.let {
                HabitTaskList(
                    list = it,
                    modifier = modifier,
                    habitViewModel
                )
            }
            Column(

                // in this column we are specifying
                // modifier to add padding and fill
                // max size
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 1.dp),

                // on below line we are adding horizontal alignment
                // and vertical arrangement
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                InfoPopup()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    TextField(
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                                )
                    )
                }
                Button(
                    onClick = { habitViewModel.addHabitToDB(text.text) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(width = 1.dp, color = Color.White)
                ) {
                    Text(
                        text = "Add Habit",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp)
                }
            }
        }
    }
}

/*  TextField(
      value = text,               //TODO
      onValueChange = { newText ->
          text = newText
      }
  ) */
//onClick = {habitViewModel.addHabitToDB(text.text) }
