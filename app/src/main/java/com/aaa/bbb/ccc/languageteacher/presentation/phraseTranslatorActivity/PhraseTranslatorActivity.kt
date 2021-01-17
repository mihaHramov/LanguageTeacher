package com.aaa.bbb.ccc.languageteacher.presentation.phraseTranslatorActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        App.getInjector().getComponentTranslateActivityComponent()?.inject(this)
        super.onCreate(savedInstanceState)
        val text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
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