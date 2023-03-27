package com.example.habitapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen

@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel
    ){

    //This is how data is moved between composable functions and database.
    val habitList by habitViewModel.allHabits.observeAsState()

    //used to capture text from TextField.
    var text by remember { mutableStateOf(TextFieldValue(""))}

    Column(modifier = modifier){
        Row(modifier = modifier){
            TextField(
                value = text,
                onValueChange = {newText ->
                    text = newText
                }
            )
            //Adds habits to db
            Button(onClick = { habitViewModel.addHabitToDB(text.text)} ){

            }
        }
        habitList?.let {
            HabitTaskList(
                list = it,
                modifier = modifier,
                habitViewModel
            )
        }
        //todo Delete these?
        /*Row(modifier = modifier) {
            StreaksScreen()
            SettingsScreen()
        }*/
    }
    }


