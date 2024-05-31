package com.example.marvel.util

import androidx.compose.ui.res.stringResource
import com.example.marvel.R
import com.example.marvel.dto.CharacterDto
import com.example.marvel.model.CharacterModel

object DtoModelMapper {
    public fun dtoToModel(dto: CharacterDto): CharacterModel {
        return CharacterModel(
            id = dto.id,
            name = dto.name?: "Mr Placeholder",
            catchPhrase = dto.description?: "I\'m here to chew bubblegum and to placehold things, and I\'m all outta gum",
            img = "${
                dto.thumbnail?.path?.replace(
                    oldValue = "http",
                    newValue = "https"
                )
            }.${dto.thumbnail?.extension}"
        )
    }
}