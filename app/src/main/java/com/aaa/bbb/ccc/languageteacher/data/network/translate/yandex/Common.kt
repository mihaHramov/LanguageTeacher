package com.aaa.bbb.ccc.languageteacher.data.network.translate.yandex

object Common {
    private val BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/"
    val retrofitService: YandexTranslateServices
        get() = YandexRetrofitClient.getClient(BASE_URL).create(YandexTranslateServices::class.java)
}