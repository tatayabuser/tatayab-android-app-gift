package com.tatayab.model.filter

enum class SortType {
    ASCENDING() {
        override fun toString(): String {
            return "asc"
        }
    },
    DESCENDING() {
        override fun toString(): String {
            return "desc"
        }
    },
    NO_FILTER() {
        override fun toString(): String {
            return ""
        }
    }

}
