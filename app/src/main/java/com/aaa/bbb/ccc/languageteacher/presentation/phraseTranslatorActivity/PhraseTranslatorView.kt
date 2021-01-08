package com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface PhraseTranslatorView : MvpView {
    @AddToEndSingle
    fun exitScreen()

    @AddToEndSingle
    fun displayTranslatorResult(result: String)

    @AddToEndSingle
    fun displayError(error: Int)

}