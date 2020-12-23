package com.aaa.bbb.ccc.languageteacher.presentation.phraseEditorFragment

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PhraseEditorPresenter : MvpPresenter<PhraseEditorView>() {
    fun save(phrase: String, translate: String) {
        viewState.displaySuccess()
    }

    fun init(text: String?) {
       if (text!=null)
           viewState.showPhrase(text)
        //make request to server for translate
    }

}