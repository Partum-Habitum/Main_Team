package com.example.habitapp

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HabitCards(
    habitName: String,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel,
    deleteID: Int
)
{
    Row(modifier = modifier){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .weight(1f)
                .padding(start = 1.dp)
                .pointerInput(Unit){
                    detectHorizontalDragGestures{_, dragAmount ->
                        when {
                            dragAmount >= 20f -> viewModel.removeHabit(deleteID)
                        }
                    }
                },
            text = habitName
        )
    }
}