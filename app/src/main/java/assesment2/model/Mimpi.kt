package assesment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mimpi")
data class Mimpi(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val mimpi: String,
    val suasana: String,
    val tanggal: String
)
