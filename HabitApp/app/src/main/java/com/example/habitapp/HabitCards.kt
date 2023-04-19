package com.example.habitapp



import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HabitCards(
    habitName: String,
    modifier: Modifier = Modifier,
    viewModel: HabitViewModel
) {
    Row(
        modifier = modifier
    ) {
        Button(modifier = Modifier,
            //.padding(top = 10.dp),
            shape = CircleShape,
            colors = buttonColors(Color.White),
            onClick = {}) {
            Image(
                painterResource(id = R.drawable.ic_info),
                contentDescription = "Info Button",
                modifier = Modifier.size(22.dp)
            )
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
                .padding(top = 12.dp, bottom = 0.dp),

            text = habitName,
            style = TextStyle(fontSize = 20.sp)
        )

        //deletes habit from database
        Button(modifier = Modifier,
           // .padding(top = 10.dp),
            shape = CircleShape,
            colors = buttonColors(Color.White),
            onClick = { viewModel.deleteHabit(habitName) }) {
            Image(
                painterResource(id = R.drawable.ic_del),
                contentDescription = "Info Button",
                modifier = Modifier.size(22.dp)
            )
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Row() {
            checkboxOrganized()
        }
    }
}

private val daysList: List<String> = listOf("1", "2", "3", "4", "5", "6" , "7")

@Composable
private fun checkboxOrganized() {

    val contextForToast = LocalContext.current.applicationContext

    //Column(horizontalAlignment = Alignment.Start) {
        Row(verticalAlignment = Alignment.CenterVertically) {
        daysList.forEach { day ->

            var checked by remember {
                mutableStateOf(true)
            }
                    Checkbox(
                        checked = checked, //Logic should go in here for the database
                        onCheckedChange = { checked_ ->
                            checked = checked_
                            Toast.makeText(contextForToast, "$day $checked_", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                Text(
                    modifier = Modifier,
                    text = day
                )
            }
        }
    }
