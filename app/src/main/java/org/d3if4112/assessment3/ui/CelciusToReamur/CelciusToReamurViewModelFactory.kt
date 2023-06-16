package org.d3if4112.assessment3.ui.CelciusToReamur

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4112.assessment3.db.SuhuDao


class CelciusToReamurViewModelFactory(private val itemDao: SuhuDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CelciusToReamurViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CelciusToReamurViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}