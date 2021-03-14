package com.aaa.bbb.ccc.languageteacher.data.network.translate.yandex

import com.aaa.bbb.ccc.languageteacher.data.network.translate.yandex.model.YandexTranslateResult
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexTranslateServices {
    @GET("translate")
    fun getTranslate(
        @Query("key") key: String,
        @Query("lang") lang:
        String, @Query("text") text: String
    ): YandexTranslateResult
}