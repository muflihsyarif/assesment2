package assesment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import assesment2.model.Mimpi
import kotlinx.coroutines.flow.Flow

@Dao
interface MimpiDao {

    @Insert
    suspend fun insert(mimpi: Mimpi)

    @Update
    suspend fun update(mimpi: Mimpi)

    @Query("SELECT * FROM mimpi ORDER BY tanggal DESC")
    fun getMimpi(): Flow<List<Mimpi>>

    @Query("SELECT * FROM mimpi WHERE id = :id")
    suspend fun getMimpiByid(id: Long): Mimpi?

    @Query("DELETE FROM mimpi WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("UPDATE mimpi SET isDeleted = 1 WHERE id = :id")
    suspend fun softDeleteById(id: Long)

    @Query("UPDATE mimpi SET isDeleted = 0 WHERE id = :id")
    suspend fun undoDeleteById(id: Long)
}