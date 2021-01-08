package com.aaa.bbb.ccc.languageteacher.di.module

import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.IPhraseTranslatorInteractor
import com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity.PhraseTranslatorPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun providePhraseTranslatePresenter(interactor: IPhraseTranslatorInteractor) =
        PhraseTranslatorPresenter(interactor)
}