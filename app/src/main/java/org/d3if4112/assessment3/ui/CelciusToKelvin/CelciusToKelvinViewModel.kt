package org.d3if4112.assessment3.ui.CelciusToKelvin

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4112.assessment3.db.SuhuDao
import org.d3if4112.assessment3.db.SuhuEntity
import org.d3if4112.assessment3.model.HasilKonversiSuhu
import org.d3if4112.assessment3.model.hitungKonversiSuhu

class CelciusToKelvinViewModel(private val db: SuhuDao) : ViewModel() {
    private val hasilKonversi = MutableLiveData<HasilKonversiSuhu?>()

    fun getHasilKonversiSuhu(): LiveData<HasilKonversiSuhu?> = hasilKonversi

    fun hitungKonversiSuhuCelciusToKelvin(suhuCeclius: Float) {
        val hasil = suhuCeclius+273
        val dataKonversi = SuhuEntity(
            suhuCelcius = suhuCeclius,
            hasilConvertCelcius = "${hasil}°K"
        )
        hasilKonversi.value = dataKonversi.hitungKonversiSuhu()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataKonversi)
            }
        }

        fun gethasilKonversi(): Float{
            return hasil
        }

        fun isEntryValid(suhuCelcius: String): Boolean {
            if (suhuCelcius.isBlank()) {
                return false
            }
            return true
        }
    }
    fun getHasilBmi(): LiveData<HasilKonversiSuhu?> = hasilKonversi
}
