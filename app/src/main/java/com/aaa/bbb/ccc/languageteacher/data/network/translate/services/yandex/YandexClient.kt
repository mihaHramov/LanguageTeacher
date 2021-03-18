package com.aaa.bbb.ccc.languageteacher.data.network.translate.services.yandex

import com.aaa.bbb.ccc.languageteacher.data.network.translate.ITranslate
import io.reactivex.Observable

class YandexClient(
    private val mTranslateServices: YandexTranslateServices,
    private val mKey: String
) : ITranslate {
    override fun translate(text: String, langFrom: String, langTo: String): Observable<String> =
        mTranslateServices.getTranslate(mKey, "$langFrom-$langFrom", text)
            .flatMap { Observable.fromIterable(it.text) }.firstOrError().toObservable()

}