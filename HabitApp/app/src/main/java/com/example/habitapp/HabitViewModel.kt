package com.example.habitapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import kotlin.collections.ArrayList

class HabitViewModel: ViewModel() {
    private val _habits = getDay1List().toMutableStateList()
    private val _habits2 = getDay2List().toMutableStateList()
    val habits: List<HabitTask>
        get() = _habits

    val habits2:List<HabitTask>
        get() = _habits2


}

val date: LocalDate = LocalDate.now()
val habit1 = HabitTask(1, "Make bed", date)
val habit2 = HabitTask(2, "Brush teeth", date)
val habit3 = HabitTask(3, "Feed pet", date)



fun getDay1List() =
    listOf<HabitTask>(habit1, habit2, habit3)

fun getDay2List() =
    listOf<HabitTask>(habit1, habit2, habit3)