package com.aaa.bbb.ccc.languageteacher.data.network.translate.services.yandex

import com.aaa.bbb.ccc.languageteacher.data.network.translate.services.yandex.model.YandexTranslateResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexTranslateServices {
    @GET("translate")
    fun getTranslate(
        @Query("key") key: String,
        @Query("lang") lang:
        String, @Query("text") text: String
    ): Observable<YandexTranslateResult>
}