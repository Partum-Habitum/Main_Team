package com.example.habitapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

    @Composable
    fun HabitTaskList(
        list: List<HabitTask>,
        modifier: Modifier = Modifier
    ){ LazyColumn(
             modifier = modifier
         ){
         items(
            items = list,
            key = {habit -> habit.id}
        ){habit ->
            HabitCards(
                habitName = habit.Task)
         }
         }
     }
