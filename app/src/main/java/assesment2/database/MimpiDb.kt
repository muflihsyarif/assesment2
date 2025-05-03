package assesment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import assesment2.model.Mimpi

@Database(entities = [Mimpi::class], version = 2, exportSchema = false)
abstract class MimpiDb: RoomDatabase() {

    abstract val dao: MimpiDao

    companion object{

        @Volatile
        private var INSTANCE: MimpiDb? = null

        fun getInstance(context: Context): MimpiDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MimpiDb::class.java,
                        "mimpi.db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}