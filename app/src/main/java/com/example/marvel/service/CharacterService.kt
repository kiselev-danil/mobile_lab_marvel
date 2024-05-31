package com.example.marvel.service

import com.example.marvel.dto.ApiResponseDto
import com.example.marvel.dto.CharacterDto
import com.example.marvel.model.CharacterModel
import com.example.marvel.util.DtoModelMapper

class CharacterService(private val service: MarvelService) {
    suspend fun findAllCharacters(): MutableList<CharacterModel>? {
        var isError = false
        val allHeroes: ApiResponseDto
        val characters = mutableListOf<CharacterModel>()
        try {
            allHeroes = service.findAll()
            if (allHeroes.code == 200) {
                with(allHeroes.data!!.results) {
                    for (i in this.indices) {
                        val heroDto: CharacterDto = this[i]
                        val heroModel = DtoModelMapper.dtoToModel(heroDto)
                        characters.add(heroModel)
                    }
                }
            } else {
                isError = true
            }
        } catch (e: Exception) {
            isError = true
        }
        if (isError) {
            return null
        }
        return characters
    }

    suspend fun findCharacterById(id: String): CharacterModel? {
        val character: CharacterModel
        val response = service.findById(id)
        if (response.code == 200) {
            with(response.data?.results?.first()) {
                this?.let { return@findCharacterById DtoModelMapper.dtoToModel(this) }
            }
        }
        return null
    }
}