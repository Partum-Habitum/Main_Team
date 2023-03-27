package com.example.habitapp



import androidx.compose.foundation.layout.Row



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

@Composable
fun HabitCards(
    habitName: String,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel
){
    Row(
        modifier = modifier){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .weight(1f)
                .padding(start = 1.dp),
            text = habitName)
        //deletes habit from database
        Button(onClick = { viewModel.deleteHabit(habitName) }) {
            
        }
    }

}