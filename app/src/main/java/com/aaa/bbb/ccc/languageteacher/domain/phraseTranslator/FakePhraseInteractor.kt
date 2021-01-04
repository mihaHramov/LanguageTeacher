package com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator

import io.reactivex.Single

class FakePhraseInteractor :IPhraseTranslatorInteractor {
    override fun getTranslate(query: String): Single<String> {
        return Single.just(query)
    }
}