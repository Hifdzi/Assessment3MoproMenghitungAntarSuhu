package org.d3if4112.assessment3.ui.histori

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4112.assessment3.db.SuhuDao
import org.d3if4112.assessment3.model.HasilKonversiSuhu

class HistoriViewModel(private val db: SuhuDao) : ViewModel() {
    private val hasilKonversiSuhu = MutableLiveData<HasilKonversiSuhu?>()

    val data = db.getKonversiSuhu()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            db.clearData()
        }
    }
}