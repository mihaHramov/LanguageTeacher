package com.aaa.bbb.ccc.languageteacher.presentation.phraseEditorFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aaa.bbb.ccc.languageteacher.R
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class PhaseEditorFragment : MvpAppCompatFragment(), PhraseEditorView {

    @InjectPresenter
    lateinit var presenter: PhraseEditorPresenter
    private lateinit var mTranslate: EditText
    private lateinit var mPhrase: EditText
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_phrase_editor, container, false)
        view.findViewById<Button>(R.id.save).setOnClickListener {
            presenter.save(mTranslate.text.toString(), mPhrase.text.toString())
        }

        mTranslate = view.findViewById(R.id.phrase_translate)
        val text = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activity?.intent?.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)?.toString()
        } else{
           ""
        }
        presenter.init(text)
        return view
    }

    override fun displaySuccess() {
        Toast.makeText(activity, "yes", Toast.LENGTH_LONG).show()
    }

    override fun showPhrase(text: String) {
        mPhrase.setText(text)
    }
}