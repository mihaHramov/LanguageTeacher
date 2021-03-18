package com.aaa.bbb.ccc.languageteacher.data.network.translate.services.google

import com.aaa.bbb.ccc.languageteacher.data.network.translate.ITranslate
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import io.reactivex.Completable
import io.reactivex.Observable

class GoogleClient : ITranslate {
    private lateinit var translator: Translator

    fun getTranslate(langFrom: String, langTo: String, text: String): Observable<String> {

        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        val options = TranslatorOptions.Builder()
            .setSourceLanguage(langFrom)
            .setTargetLanguage(langTo)
            .build()
        translator = Translation.getClient(options)
        return Completable.create { completableEmitter ->
            translator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    completableEmitter.onComplete()
                }
                .addOnFailureListener { exception ->
                    completableEmitter.onError(exception)
                }
        }.andThen(Observable.just(text))
            .flatMap { q ->
                Observable.create {
                    translator.translate(q)
                        .addOnSuccessListener { translatedText ->
                            it.onNext(translatedText)
                            it.onComplete()
                        }
                        .addOnFailureListener { exception ->
                            it.onError(exception)
                        }
                }
            }
    }

    override fun translate(text: String, langFrom: String, langTo: String): Observable<String> {
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        val options = TranslatorOptions.Builder()
            .setSourceLanguage(langFrom)
            .setTargetLanguage(langTo)
            .build()
        translator = Translation.getClient(options)
        return Completable.create { completableEmitter ->
            translator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    completableEmitter.onComplete()
                }
                .addOnFailureListener { exception ->
                    completableEmitter.onError(exception)
                }
        }.andThen(Observable.just(text))
            .flatMap { q ->
                Observable.create {
                    translator.translate(q)
                        .addOnSuccessListener { translatedText ->
                            it.onNext(translatedText)
                            it.onComplete()
                        }
                        .addOnFailureListener { exception ->
                            it.onError(exception)
                        }
                }
            }
    }
}

