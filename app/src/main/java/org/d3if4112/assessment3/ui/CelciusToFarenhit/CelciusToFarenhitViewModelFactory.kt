package org.d3if4112.assessment3.ui.CelciusToFarenhit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4112.assessment3.db.SuhuDao

class CelciusToFarenhitViewModelFactory(private val itemDao: SuhuDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CelciusToFarenhitViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CelciusToFarenhitViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}