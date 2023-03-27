package com.example.habitapp

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen

@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel
) {

    //This is how data is moved between composable functions and database.
    val habitList by habitViewModel.allHabits.observeAsState()

    //used to capture text from TextField.
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
        Row(modifier = modifier.padding(1.dp)) {
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                }
            )
            //Adds habits to db
            Button(onClick = { habitViewModel.addHabitToDB(text.text) }) {

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

    //This is the button and text field alignment
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
    ) {
        Row(
            modifier = modifier,
        ) {
            Button(
                onClick = {habitViewModel.addHabitToDB(text.text) },
                Modifier.padding(8.dp),
                shape = CircleShape,
            )
            {
                Text(
                    text = "+",
                    Modifier.padding(3.dp),
                    fontSize = 30.sp
                )
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

