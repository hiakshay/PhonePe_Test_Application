package com.akshay.phonepetestapplication.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akshay.phonepetestapplication.repository.MainRepository
import com.akshay.phonepetestapplication.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) : BaseViewModel() {

    private val _tenthCharArray = MutableLiveData<ArrayList<Char>>()
    val tenthCharArray: LiveData<ArrayList<Char>> = _tenthCharArray

    private val _tenthChar = MutableLiveData<Char>()
    val tenthChar: LiveData<Char> = _tenthChar

    private val _wordCounterText = MutableLiveData<Int>()
    val wordCounterText: LiveData<Int> = _wordCounterText


    fun makeThreeSimultaneousRequests() {
        _loading.value = true


        makeTenthCharRequest()

        makeTenthCharArrayRequest()

        makeWordCounterRequest()

    }

    private fun makeWordCounterRequest() {
        mainRepository.wordCounterRequest().call(
            {
                updateValues(it)
            }, {
                onError(it)
            }
        )
    }

    private fun makeTenthCharArrayRequest() {
        mainRepository.tenthCharArrayRequest().call(
            {
                updateValues(it)
            }, {
                onError(it)
            }
        )
    }

    private fun makeTenthCharRequest() {
        mainRepository.tenthCharRequest().call(
            {
                updateValues(it)
            }, {
                onError(it)
            }
        )
    }

    private fun updateValues(it: Any?) {
        _loading.value = false
        when (it) {
            is Char -> {
                _tenthChar.value = it
            }
            is ArrayList<*> -> {
                _tenthCharArray.value = it as ArrayList<Char>?
            }
            is Int -> {
                _wordCounterText.value = it
            }
            else -> Unit
        }
    }

    private fun onError(error: Throwable?) {
        error?.let {
            _loading.value = false
            _errorMessage.value = it.message
            Utils.captureException(error)
        }
    }
}