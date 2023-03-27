package com.example.habitapp

import Database.Habit
import Database.HabitDao
import Database.HabitDatabase
import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDate

@RunWith(AndroidJUnit4::class)
class HabitDataBaseTest {
    private val TAG = "HabitSearch"
    private lateinit var habitDao: HabitDao
    private lateinit var db: HabitDatabase

    @Before
    fun createDB(){
        val context =
            InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context,
            HabitDatabase::class.java
            ).allowMainThreadQueries()
            .build()

        habitDao = db.habitDao()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetTodo() = runBlocking {
        val habit = Habit("Work out")
        habitDao.insertHabit(habit)
        val oneHabit = habitDao.getHabit(1)
        Log.i(TAG, habitDao.getHabit(1).toString())
        assertEquals(oneHabit?.id,1)
    }
}


