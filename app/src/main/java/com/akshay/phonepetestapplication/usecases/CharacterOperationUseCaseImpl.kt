package com.akshay.phonepetestapplication.usecases

import javax.inject.Inject

class CharacterOperationUseCaseImpl @Inject constructor() : CharacterOperationUseCase {

    override fun wordCounterRequestOperation(content: String): Int {
        val words = content.trim()
        return words.split("\\s+".toRegex()).size
    }

    override fun everyTenthCharacterRequestOperation(content: String): List<Char> {
        val charArray = ArrayList<Char>()
        content.forEachIndexed { index, c ->
            if ((index + 1) % 10 == 0) charArray += c
        }
        return charArray
    }

    override fun tenthCharacterRequestOperation(content: String): Char {
        return content[9]
    }

}