package Database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "habits_table")
 class Habit
    ( habitName: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    /*@ColumnInfo(name = "Date")
    var dateCompleted: LocalDate? = null*/

    @ColumnInfo(name = "habits")
     val habitName: String? = habitName

    @ColumnInfo(name = "completed")
    var completed: Boolean = false

    @ColumnInfo(name = "streaks")
    var streaks: Int = 0


    init {
        habitName
        completed
        streaks
    }
}