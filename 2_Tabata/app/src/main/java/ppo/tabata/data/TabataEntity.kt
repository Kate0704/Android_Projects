package ppo.tabata.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TabataEntity(
    var name: String,
    var color: Int,
    var warm_up: Int,
    var work: Int,
    var rest: Int,
    var repeats: Int,
    var cycles: Int,
    var cooldown:Int
) : Serializable
{
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}