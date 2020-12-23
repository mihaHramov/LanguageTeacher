package com.aaa.bbb.ccc.languageteacher.presentation.phraseEditorActivity


import android.os.Bundle
import android.os.PersistableBundle
import com.aaa.bbb.ccc.languageteacher.R
import com.aaa.bbb.ccc.languageteacher.presentation.phraseEditorFragment.PhaseEditorFragment
import moxy.MvpAppCompatActivity

class PhraseEditorActivity : MvpAppCompatActivity(R.layout.activity_phrase_editor) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.host_fragment, PhaseEditorFragment())
            .commit()
    }
}