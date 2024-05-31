package com.example.marvel.dto

import com.squareup.moshi.Json

class CharacterThumbnailDto(
    @Json(name = "path") var path: String? = null,
    @Json(name = "extension") var extension: String? = null
) {
}