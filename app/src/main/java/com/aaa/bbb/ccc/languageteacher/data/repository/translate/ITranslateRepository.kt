package com.aaa.bbb.ccc.languageteacher.data.repository.translate

import io.reactivex.Single

interface ITranslateRepository {
    fun getTranslate(query: String, langFrom: String, langTo: String): Single<String>
}