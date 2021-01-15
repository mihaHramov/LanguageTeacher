package com.aaa.bbb.ccc.languageteacher.di.component

import com.aaa.bbb.ccc.languageteacher.di.module.PhraseTranslateModule
import com.aaa.bbb.ccc.languageteacher.di.scope.PhraseTranslatorScope
import com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity.PhraseTranslatorActivity
import dagger.Subcomponent

@PhraseTranslatorScope
@Subcomponent(modules = [PhraseTranslateModule::class])
interface PhraseTranslateActivityComponent {
    fun inject(activity: PhraseTranslatorActivity)
}