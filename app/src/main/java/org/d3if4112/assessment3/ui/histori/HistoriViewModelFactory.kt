package org.d3if4112.assessment3.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4112.assessment3.db.SuhuDao
import java.lang.IllegalArgumentException

class HistoriViewModelFactory(
    private val db: SuhuDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriViewModel::class.java)){
            return HistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Uknown ViewModel Class")
    }
}