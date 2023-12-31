package org.d3if4112.assessment3.adapter

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if4112.assessment3.R
import org.d3if4112.assessment3.databinding.ItemHistoriBinding
import org.d3if4112.assessment3.db.SuhuEntity
import org.d3if4112.assessment3.model.hitungKonversiSuhu
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<SuhuEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<SuhuEntity>() {
                override fun areItemsTheSame(
                    oldData: SuhuEntity, newData: SuhuEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: SuhuEntity, newData: SuhuEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )
        fun bind(item: SuhuEntity) = with(binding) {
            val hasilKonversiSuhu = item.hitungKonversiSuhu()
            kategoriTextView.text = hasilKonversiSuhu.suhuConvert
            val colorRes = R.color.blue_500
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(ContextCompat.getColor(root.context, colorRes))
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = "Suhu Celcius ${item.suhuCelcius}℃"
            dataTextView.text = "Hasil Convert ${item.hasilConvertCelcius}"
        }
    }


}