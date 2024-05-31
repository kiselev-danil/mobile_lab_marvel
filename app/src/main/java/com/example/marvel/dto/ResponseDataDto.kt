package com.example.marvel.dto;

import com.squareup.moshi.Json;

data class ResponseDataDto(
    @Json(name = "results")
    var results: List<CharacterDto> = listOf()
)
