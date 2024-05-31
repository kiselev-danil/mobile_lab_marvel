package com.example.marvel.dto

import com.squareup.moshi.Json

data class CharacterDto(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "modified") var modified: String? = null,
    @Json(name = "thumbnail") var thumbnail: CharacterThumbnailDto? = CharacterThumbnailDto(),
    @Json(name = "resourceURI") var resourceURI: String? = null,
)
