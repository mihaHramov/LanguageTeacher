package com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.aaa.bbb.ccc.languageteacher.App
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class PhraseTranslatorActivity : MvpAppCompatActivity(), PhraseTranslatorView {

    @Inject
    lateinit var presenterProvider: Provider<PhraseTranslatorPresenter>
    private val presenter: PhraseTranslatorPresenter by moxyPresenter { presenterProvider.get() }

    override fun displayTranslatorResult(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.getInjector().getComponentTranslateActivityComponent()?.inject(this)
        val text =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT) != null) {
                intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
            } else {
                ""
            }
        presenter.init(text)
    }

    override fun exitScreen() {
        finish()
    }


    override fun displayError(error: Int) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun finish() {
        super.finish()
        App.getInjector().clearComponentTranslateActivityComponent()
    }
}