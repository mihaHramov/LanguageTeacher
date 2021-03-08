package com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator

import android.Manifest
import com.aaa.bbb.ccc.languageteacher.data.repository.permissions.IPermissionsRepository
import com.aaa.bbb.ccc.languageteacher.data.repository.translate.ITranslateRepository
import io.reactivex.Single

class PhraseTranslatorInteracor(
    private val mTranslateRepository: ITranslateRepository,
    private val mPermissionsRepository: IPermissionsRepository
) :
    IPhraseTranslatorInteractor {
    private val langHardCode = "en"


    override fun getTranslate(query: String) =
        mPermissionsRepository.getPermissions(Manifest.permission.INTERNET)
            .flatMapSingle {
                if (it) Single.just(query) else Single.error(Throwable("err"))
            }
            .filter { it.isNotEmpty() }
            .flatMapSingle {
                mTranslateRepository.getTranslate(it, langHardCode, langHardCode)
            }

}