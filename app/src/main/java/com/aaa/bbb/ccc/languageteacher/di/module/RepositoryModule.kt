package com.aaa.bbb.ccc.languageteacher.di.module

import com.aaa.bbb.ccc.languageteacher.data.repository.translate.FakeTranslateRepository
import com.aaa.bbb.ccc.languageteacher.data.repository.translate.ITranslateRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideITranslateRepository(): ITranslateRepository = FakeTranslateRepository()

}