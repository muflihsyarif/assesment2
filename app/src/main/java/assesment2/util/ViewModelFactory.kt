package assesment2.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import assesment2.database.MimpiDb
import assesment2.ui.screen.DetailViewModel
import assesment2.ui.screen.MainViewModel

class ViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       val dao = MimpiDb.getInstance(context).dao
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        }else if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(dao) as T
        throw IllegalArgumentException("Unknown viewModel class")
    }
}