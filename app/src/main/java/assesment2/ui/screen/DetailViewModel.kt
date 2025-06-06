package assesment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import assesment2.database.MimpiDao
import assesment2.model.Mimpi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: MimpiDao): ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(judul: String, isi: String, suasana: String){
        val mimpi = Mimpi(
            tanggal = formatter.format(Date()),
            judul = judul,
            mimpi = isi,
            suasana = suasana
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(mimpi)
        }
    }
    suspend fun getMimpii(id: Long): Mimpi? {
        return dao.getMimpiByid(id)
    }
    fun update(id: Long, judul: String, isi: String, suasana: String){
        val mimpi = Mimpi(
            id = id,
            tanggal = formatter.format(Date()),
            judul = judul,
            mimpi = isi,
            suasana = suasana
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(mimpi)
        }
    }
    fun softDelete(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            dao.softDeleteById(id)
        }
    }
}