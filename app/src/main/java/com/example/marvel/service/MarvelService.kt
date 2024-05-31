package com.example.marvel.service

import com.example.marvel.dto.ApiResponseDto
import com.example.marvel.repository.MarvelApiRepository

class MarvelService(private val marvelApi: MarvelApiRepository) {
    suspend fun findAll(): ApiResponseDto {
        return marvelApi.findAll()
    }

    suspend fun findById(id: String): ApiResponseDto {
        return marvelApi.findById(characterId = id)
    }
}