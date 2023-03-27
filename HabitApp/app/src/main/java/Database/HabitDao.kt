package Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HabitDao {

    @Insert
    fun insertHabit(habit: Habit)

    @Query("DELETE FROM habits_table WHERE habits = :habitName")
    fun deleteHabit(habitName:String)

    @Query("SELECT * FROM habits_table")
    fun getAllHabits(): LiveData<List<Habit>>

    @Query("SELECT * FROM habits_table where id = :id")
    fun getHabit(id: Int) : Habit?


}