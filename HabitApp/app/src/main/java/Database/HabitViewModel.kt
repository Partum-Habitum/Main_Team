package com.example.habitapp

import Database.Habit
import Database.HabitDatabase
import Database.HabitRepository
import android.app.Application
import androidx.lifecycle.*

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    var allHabits: LiveData<List<Habit>>
    private val habitRepo: HabitRepository


    init {
        val habitDao = HabitDatabase.getDatabase(application)?.habitDao()
        habitRepo = habitDao?.let { HabitRepository(it) }!!
        allHabits = habitRepo.allHabits
    }

    fun deleteHabit(text: String) {
        habitRepo.deleteHabit(text)
    }

    fun addHabitToDB(text: String) {
        val habit = Habit(text)
        habitRepo.insertContact(habit)
    }

}






