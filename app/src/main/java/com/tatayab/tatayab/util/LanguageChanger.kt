package com.tatayab.tatayab.util

import java.util.*

object LocaleCodes {
    const val ENGLISH = "en"
    const val ARABIC = "ar"
}

enum class Language(val locale: Locale) {
    English(Locale(LocaleCodes.ENGLISH)) {
        override fun toString(): String {
            return LocaleCodes.ENGLISH
        }
    },
    Arabic(Locale(LocaleCodes.ARABIC)) {
        override fun toString(): String {
            return LocaleCodes.ARABIC
        }
    };


    companion object {
        private val DEFAULT = English
        fun fromLocale(locale: Locale): Language =
            values().firstOrNull { it.locale.language == locale.language.toLowerCase(Locale.US) }
                ?: DEFAULT

        fun getLocale(storedValue: String?): Language {
            return when (storedValue) {
                LocaleCodes.ARABIC -> Arabic
                LocaleCodes.ENGLISH -> English
                else -> valueOf("unsupported")
            }
        }
    }
}