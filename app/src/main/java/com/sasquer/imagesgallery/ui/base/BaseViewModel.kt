package com.sasquer.imagesgallery.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val disposable = CompositeDisposable()

    protected open fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}