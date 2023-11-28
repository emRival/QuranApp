package com.rival.myapplication.core.data.network.quran

import retrofit2.Call
import retrofit2.http.GET

interface QuranApiService {

    //get list nama surat Al-quran
    @GET("surah")
    fun getListSurah() : Call<SurahResponse>
}