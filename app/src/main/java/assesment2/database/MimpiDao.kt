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
    fun getCatatan(): Flow<List<Mimpi>>
}