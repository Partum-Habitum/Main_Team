package com.example.habitapp



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun HabitCards(
    habitName: String,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel
){
    Row(
        modifier = modifier){
        Button( modifier = Modifier
            .padding(top = 10.dp),
            shape = CircleShape,
            colors = buttonColors(Color.White),
            onClick = {}) {
            Image(
                painterResource(id = R.drawable.ic_info),
                contentDescription ="Info Button",
                modifier = Modifier.size(22.dp))
        }
      /*  Button(modifier = Modifier
            .padding(top = 10.dp),
            shape = CircleShape,
            onClick = { /* Streaks Screen */ }) {
            Text(text = "i", fontSize = 17.sp)
        } */
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .weight(1f)
                .padding(top = 22.dp),
            text = habitName)
        //deletes habit from database
            Button( modifier = Modifier
                .padding(top = 10.dp),
                shape = CircleShape,
                colors = buttonColors(Color.White),
                onClick = { viewModel.deleteHabit(habitName) }) {
                Image(
                    painterResource(id = R.drawable.ic_del),
                    contentDescription ="Info Button",
                    modifier = Modifier.size(22.dp))
            }
    }

}