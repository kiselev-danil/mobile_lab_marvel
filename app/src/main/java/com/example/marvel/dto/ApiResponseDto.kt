package com.example.marvel.dto

import com.squareup.moshi.Json

data class ApiResponseDto(
    @Json(name = "code") var code: Int? = null,
    @Json(name = "status") var status: String? = null,
    @Json(name = "data") var data: ResponseDataDto? = ResponseDataDto()
) {}