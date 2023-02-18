package com.example.habitapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import kotlin.collections.ArrayList

class HabitViewModel: ViewModel() {
    val date: LocalDate = LocalDate.now()
    var count = 4
    private val _habits = getDay1List().toMutableStateList()
    private val _habits2 = getDay2List().toMutableStateList()
    val habits: List<HabitTask>
        get() = _habits

    val habits2:List<HabitTask>
        get() = _habits2

    fun addHabit(addHabit: String){
        _habits.add(HabitTask(count, addHabit, date))
        count++
    }

    fun removeHabit(deleteHabit: Int){
        for (x in _habits){
            if (x.id == deleteHabit){
                _habits.remove(x)
            }
        }
    }

}

val date: LocalDate = LocalDate.now()
val habit1 = HabitTask(1, "Make bed", date)
val habit2 = HabitTask(2, "Brush teeth", date)
val habit3 = HabitTask(3, "Feed pet", date)



fun getDay1List() =
    listOf<HabitTask>(habit1, habit2, habit3)

fun getDay2List() =
    listOf<HabitTask>(habit1, habit2, habit3)