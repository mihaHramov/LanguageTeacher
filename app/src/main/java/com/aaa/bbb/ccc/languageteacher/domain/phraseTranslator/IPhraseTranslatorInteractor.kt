package com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator

import io.reactivex.Single

interface IPhraseTranslatorInteractor {
    fun getTranslate(query: String): Single<String>
}