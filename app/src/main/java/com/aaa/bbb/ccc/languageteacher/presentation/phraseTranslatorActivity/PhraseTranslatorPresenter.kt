package com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity

import com.aaa.bbb.ccc.languageteacher.R
import com.aaa.bbb.ccc.languageteacher.domain.phraseTranslator.IPhraseTranslatorInteractor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PhraseTranslatorPresenter(private val interactor: IPhraseTranslatorInteractor) :
    MvpPresenter<PhraseTranslatorView>() {
    private val disposable = CompositeDisposable()

    fun init(text: String) {
        val consumerSuccess = Consumer<String> {
            viewState.displayTranslatorResult(it)
            viewState.exitScreen()
        }
        val consumerError = Consumer<Throwable> {
            viewState.displayError(R.string.translate_error)
        }

        val subscribe = Single.just(text)
            .flatMap { interactor.getTranslate(it) }
            .subscribe(consumerSuccess, consumerError)
        disposable.add(subscribe)
    }

    override fun onDestroy() {
        disposable.dispose()
    }

}