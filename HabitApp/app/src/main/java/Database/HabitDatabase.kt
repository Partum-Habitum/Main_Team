package Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Habit::class)], version = 1)
abstract class HabitDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao

    companion object {
        private var INSTANCE: HabitDatabase? = null

        internal fun getDatabase(context: Context): HabitDatabase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext,
                        HabitDatabase::class.java,
                        "habits_table"
                    ).fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE
        }
    }
}