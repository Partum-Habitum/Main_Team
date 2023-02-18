package com.example.habitapp

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun HabitCards(
    habitName: String,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel,
    deleteID: Int
){
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .pointerInput(Unit){
                       detectHorizontalDragGestures{_, dragAmount ->
                         when {
                             dragAmount >= 20f -> viewModel.removeHabit(deleteID)
                         }
                       }
                },
            text = habitName)
    }

}