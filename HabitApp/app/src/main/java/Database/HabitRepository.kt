package Database

import android.app.Application
import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitRepository(private val habitDao: HabitDao) {


    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allHabits: LiveData<List<Habit>> = habitDao.getAllHabits()


    fun insertContact(newHabit: Habit){
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newHabit)
        }
    }

     fun asyncInsert(habits:Habit){
        habitDao.insertHabit(habits)
    }

    fun deleteHabit(habit: String){
        coroutineScope.launch(Dispatchers.IO){
            asyncDelete(habit)
        }
    }

     fun asyncDelete(habit: String){
        habitDao.deleteHabit(habit)
    }

}