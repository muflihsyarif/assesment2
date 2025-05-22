package assesment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import assesment2.database.MimpiDao
import assesment2.model.Mimpi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel (private val dao: MimpiDao): ViewModel() {

    val data: StateFlow<List<Mimpi>> = dao.getMimpi().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
    fun undoDelete(id: Long){
        viewModelScope.launch (Dispatchers.IO){
            dao.undoDeleteById(id)
        }
    }
    fun deletePermanent(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}