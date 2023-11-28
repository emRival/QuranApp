package com.rival.myapplication.presentation.quran

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rival.myapplication.adapter.ListAyahAdapter
import com.rival.myapplication.core.data.network.quran.SurahItem
import com.rival.myapplication.databinding.ActivityDetailSurahBinding

class DetailSurahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSurahBinding

    val viewModel: QuranViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<SurahItem>(EXTRA_DATA)

        binding.apply {
            tvDetailAyah.text = "${data?.revelationType} - ${data?.numberOfAyahs} Ayahs"
            tvDetailName.text = data?.name
            tvDetailSurah.text = data?.englishName
            tvDetailNameTranslation.text = data?.englishNameTranslation
        }

        data?.number?.let { viewModel.getListAyah(it) }

        val mAdapter = ListAyahAdapter()

        viewModel.listAyah.observe(this@DetailSurahActivity){ayah ->
            binding.rvSurah.apply {
                mAdapter.setData(ayah.quranEdition.get(0).listAyahs, ayah.quranEdition)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@DetailSurahActivity)
            }


        }




    }


}