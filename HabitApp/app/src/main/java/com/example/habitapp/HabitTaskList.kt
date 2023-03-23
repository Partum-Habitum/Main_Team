package com.example.habitapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
    fun HabitTaskList(
        list: List<HabitTask>,
        modifier: Modifier = Modifier,

        viewModel: HabitViewModel
    ){ LazyColumn(modifier = modifier){
         items(
            items = list,
            key = {habit -> habit.id}
        ){habit ->
            HabitCards(
                habitName = habit.Task,
                modifier = modifier.padding(35.dp),
                viewModel,
                deleteID = habit.id
                )

         }
         }
     }
