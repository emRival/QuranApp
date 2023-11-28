package com.rival.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rival.myapplication.core.data.network.quran.AyahsItem
import com.rival.myapplication.core.data.network.quran.QuranEditionItem
import com.rival.myapplication.databinding.ItemAyahBinding

class ListAyahAdapter : RecyclerView.Adapter<ListAyahAdapter.AyahViewHolder>() {

    val listAyah = ArrayList<AyahsItem>()
    val listQuranEdition = ArrayList<QuranEditionItem>()

    fun setData(dataAyah: List<AyahsItem>, dataEdition: List<QuranEditionItem>) {
        if (dataAyah == null || dataEdition == null) return
        listAyah.clear()
        listAyah.addAll(dataAyah)
        listQuranEdition.clear()
        listQuranEdition.addAll(dataEdition)
    }

    class AyahViewHolder(val binding: ItemAyahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder =
        AyahViewHolder(
            ItemAyahBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    override fun getItemCount(): Int = listAyah.size

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        val listAyah = listAyah[position]
        val quranAudio = listQuranEdition[1]
        val quranTranslateIndo = listQuranEdition[2]

        holder.binding.apply {
            itemNumberAyah.text = listAyah.numberInSurah.toString()
            itemAyah.text = listAyah.text
            itemTranslation.text = quranTranslateIndo.listAyahs.get(position).text
        }
    }
}