package com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator

import com.aaa.bbb.ccc.languageteacher.data.repository.translate.ITranslateRepository
import io.reactivex.Single

class PhraseTranslatorInteracor(private val translateRepository: ITranslateRepository) :
    IPhraseTranslatorInteractor {
    private val langHardCode = "en"
    override fun getTranslate(query: String): Single<String> {
        return Single.just(query)
            .filter { it.isNotEmpty() }
            .flatMapSingle { translateRepository.getTranslate(query, langHardCode, langHardCode) }
    }
}