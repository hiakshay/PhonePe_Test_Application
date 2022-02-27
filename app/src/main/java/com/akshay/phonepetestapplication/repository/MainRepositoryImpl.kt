package com.akshay.phonepetestapplication.repository

import com.akshay.phonepetestapplication.network.api.MoviesContentAPI
import com.akshay.phonepetestapplication.usecases.CharacterOperationUseCase
import io.reactivex.Observable
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val moviesContentAPI: MoviesContentAPI,
    private val characterOperationUseCase: CharacterOperationUseCase
) : MainRepository {

    override fun getContent(): Observable<String> {
        return Observable.empty()
    }

    override fun wordCounterRequest(): Observable<Int> {
        return getContent().map {
            characterOperationUseCase.wordCounterRequestOperation(it)
        }
    }

    override fun tenthCharRequest(): Observable<Char> {
        return getContent().map {
            characterOperationUseCase.tenthCharacterRequestOperation(it)
        }
    }

    override fun tenthCharArrayRequest(): Observable<List<Char>> {
        return getContent().map {
            characterOperationUseCase.everyTenthCharacterRequestOperation(it)
        }
    }
}