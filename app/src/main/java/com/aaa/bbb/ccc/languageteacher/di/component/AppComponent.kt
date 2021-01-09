package com.aaa.bbb.ccc.languageteacher.di.component

import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent {
    fun getTranslateActivityComponent(): PhraseTranslateActivityComponent
}