package org.d3if4112.assessment3.model

import org.d3if4112.assessment3.db.SuhuEntity


fun SuhuEntity.hitungKonversiSuhu(): HasilKonversiSuhu {

    return HasilKonversiSuhu(suhuCelcius,hasilConvertCelcius)
}
