package com.tatayab.presentation.mapper

interface PresentationMapper<E, D> {
    fun mapToEntity(domain: D): E
}
