package com.example.habitapp

import Database.Habit
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData

@Composable

    fun HabitTaskList(
    list: List<Habit>,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel
    ){ LazyColumn(
             modifier = modifier
         ){
         items(
            items = list,
             key = {habit -> habit.id}
        ){habit: Habit ->
             habit.habitName
             habit.habitName?.let {
                 HabitCards(
                     habitName = it,
                     modifier = modifier,
                     viewModel
                     //deleteID = habit.id
                 )
             }


         }
         }
     }




