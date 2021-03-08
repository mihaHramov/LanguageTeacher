package com.aaa.bbb.ccc.languageteacher.di.module

import com.aaa.bbb.ccc.languageteacher.data.repository.permissions.IPermissionsRepository
import com.aaa.bbb.ccc.languageteacher.data.repository.translate.FakeTranslateRepository
import com.aaa.bbb.ccc.languageteacher.data.repository.translate.ITranslateRepository
import com.aaa.bbb.ccc.languageteacher.di.scope.PhraseTranslatorScope
import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.IPhraseTranslatorInteractor
import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.PhraseTranslatorInteracor
import com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity.PhraseTranslatorPresenter
import dagger.Module
import dagger.Provides

@Module
class PhraseTranslateModule {
    @Provides
    @PhraseTranslatorScope
    fun providePhraseTranslatePresenter(interactor: IPhraseTranslatorInteractor) =
        PhraseTranslatorPresenter(interactor)

    @Provides
    @PhraseTranslatorScope
    fun provideIPhraseInteractor(repository: ITranslateRepository,permission: IPermissionsRepository): IPhraseTranslatorInteractor =
        PhraseTranslatorInteracor(repository,permission)


    @Provides
    @PhraseTranslatorScope
    fun provideITranslateRepository(): ITranslateRepository = FakeTranslateRepository()
}