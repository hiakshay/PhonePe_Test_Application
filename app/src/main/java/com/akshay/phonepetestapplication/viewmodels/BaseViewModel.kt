package com.akshay.phonepetestapplication.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage

    protected val _loading = MutableLiveData(false)
    val loading = _loading

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


    fun <T> Observable<T>?.call(
        onSuccess: ((T) -> Unit)? = null,
        onError: ((Throwable?) -> Unit)? = null
    ) {
        when (this) {
            null -> onError?.invoke(null)
            else -> compositeDisposable.add(
                observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        onSuccess?.invoke(it)
                    }, {
                        onError?.invoke(it)
                    })
            )
        }
    }
}