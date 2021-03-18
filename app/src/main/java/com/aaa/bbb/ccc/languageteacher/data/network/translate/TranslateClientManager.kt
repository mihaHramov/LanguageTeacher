package com.aaa.bbb.ccc.languageteacher.data.network.translate

import io.reactivex.Observable


class TranslateClientManager(
    private val translateYandex: ITranslate,
    private val translateGoogle: ITranslate
) : ITranslate {
    override fun translate(text: String, langFrom: String, langTo: String): Observable<String> {
        return Observable.concatArray(
            Observable.fromIterable(
                listOf(
                    translateGoogle,
                    translateYandex
                )
            )
        )
            .flatMap { it.translate(text, langFrom, langTo) }
            .firstElement()
            .toObservable()
    }
}