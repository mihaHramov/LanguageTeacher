package com.aaa.bbb.ccc.languageteacher.data.repository.translate

import io.reactivex.Single

class FakeTranslateRepository : ITranslateRepository {
    override fun getTranslate(query: String, langFrom: String, langTo: String): Single<String> = Single.just(query)
}