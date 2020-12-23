package com.aaa.bbb.ccc.languageteacher.presentation.phraseEditorFragment

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface PhraseEditorView: MvpView {
    @AddToEndSingle
    fun displaySuccess()
    @AddToEndSingle
    fun showPhrase(text: String)
}