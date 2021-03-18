package com.aaa.bbb.ccc.languageteacher.data.network.translate

import io.reactivex.Observable

interface ITranslate {
    fun translate(text:String,langFrom:String,langTo:String):Observable<String>
}