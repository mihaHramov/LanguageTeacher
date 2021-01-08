package com.aaa.bbb.ccc.languageteacher.di.module

import com.aaa.bbb.ccc.languageteacher.data.repository.translate.FakeTranslateRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideITranslateRepository() = FakeTranslateRepository()

}