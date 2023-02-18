package com.example.habitapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen

@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel = viewModel()
    ){
    var text by remember { mutableStateOf(TextFieldValue(""))}
    Column(modifier = modifier){
        Row(modifier = modifier){
            TextField(
                value = text,
                onValueChange = {newText ->
                    text = newText
                }
            )
            Button(onClick = { habitViewModel.addHabit(text.text) }) {
                
            }
        }
        HabitTaskList(
            list = habitViewModel.habits,
            modifier = modifier,
            habitViewModel
        )

        Row(modifier = modifier) {
            StreaksScreen()
            SettingsScreen()
        }
    }
    }

