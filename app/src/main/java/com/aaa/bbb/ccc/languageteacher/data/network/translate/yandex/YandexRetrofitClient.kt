package com.aaa.bbb.ccc.languageteacher.data.network.translate.yandex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object YandexRetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}