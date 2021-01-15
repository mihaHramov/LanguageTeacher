package com.aaa.bbb.ccc.languageteacher

import android.app.Application
import com.aaa.bbb.ccc.languageteacher.di.utils.Injector

class App : Application() {

    companion object {
        fun getInjector() = Injector

    }
}