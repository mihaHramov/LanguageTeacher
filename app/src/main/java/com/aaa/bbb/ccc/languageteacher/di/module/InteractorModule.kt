package com.aaa.bbb.ccc.languageteacher.di.module

import com.aaa.bbb.ccc.languageteacher.data.repository.translate.ITranslateRepository
import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.IPhraseTranslatorInteractor
import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.PhraseTranslatorInteracor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @Provides
    fun provideIPhraseInteractor(repository: ITranslateRepository): IPhraseTranslatorInteractor {
        return PhraseTranslatorInteracor(repository)
    }
}