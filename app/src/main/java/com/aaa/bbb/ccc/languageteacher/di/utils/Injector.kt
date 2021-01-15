package com.aaa.bbb.ccc.languageteacher.di.utils

import com.aaa.bbb.ccc.languageteacher.di.component.AppComponent
import com.aaa.bbb.ccc.languageteacher.di.component.DaggerAppComponent
import com.aaa.bbb.ccc.languageteacher.di.component.PhraseTranslateActivityComponent

object Injector {

    private var translateActivityComponent: PhraseTranslateActivityComponent? = null
    private var appComponent: AppComponent = DaggerAppComponent.builder().build()

    fun getAppComponent() = appComponent
    fun getComponentTranslateActivityComponent(): PhraseTranslateActivityComponent? {
        if (translateActivityComponent == null) {
            translateActivityComponent = appComponent.getTranslateActivityComponent()
        }
        return translateActivityComponent
    }

    fun clearComponentTranslateActivityComponent() {
        translateActivityComponent = null
    }
}