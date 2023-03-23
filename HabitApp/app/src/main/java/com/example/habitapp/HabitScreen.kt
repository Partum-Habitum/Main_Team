package com.example.habitapp

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habitapp.Settings.SettingsScreen
import com.example.habitapp.Streaks.StreaksScreen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitViewModel: HabitViewModel = viewModel()
    ) {
    var text by remember { mutableStateOf(TextFieldValue("")) }


    Column(modifier = modifier, horizontalAlignment = Alignment.Start,){
        Row(modifier = modifier.padding(1.dp)) {
            StreaksScreen()
            SettingsScreen()
        }
        Row(modifier = modifier) {
            HabitTaskList(
                list = habitViewModel.habits,
                modifier = modifier,
                habitViewModel,
            )
    }
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
                onClick = {habitViewModel.addHabit(text.text) },
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