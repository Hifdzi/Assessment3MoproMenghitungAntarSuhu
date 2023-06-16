package org.d3if4112.assessment3.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuhuDao {
    //
    @Insert
    fun insert(suhuDao: SuhuEntity)

    @Query("SELECT * FROM suhu ORDER BY id ASC")
    fun getKonversiSuhu(): LiveData<List<SuhuEntity?>>

    @Query("DELETE FROM suhu")
    fun clearData()

    @Update
    fun updateData(suhu: SuhuEntity)

}