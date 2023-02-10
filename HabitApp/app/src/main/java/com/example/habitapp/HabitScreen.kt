package com.example.habitapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen

@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel = viewModel()
    ){
    Column(modifier = modifier){
        HabitTaskList(
            list = habitViewModel.habits
        )

        Row(modifier = modifier) {
            StreaksScreen()
            SettingsScreen()
        }
    }
    }

