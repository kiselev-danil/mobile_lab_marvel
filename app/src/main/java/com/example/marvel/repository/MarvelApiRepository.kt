package com.example.marvel.repository

import androidx.annotation.Keep
import com.example.marvel.dto.ApiResponseDto
import com.example.marvel.util.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

@Keep
public interface MarvelApiRepository {
    @GET("/v1/public/characters/{characterId}")
    suspend fun findById(
        @Path("characterId") characterId: String,
        @Query("apikey") apiKey: String = ApiConstants.PUBLIC_KEY,
        @Query("ts") ts: String = ApiConstants.TIMESTAMP,
        @Query("hash") hash: String = ApiConstants.createHash()
    ): ApiResponseDto

    @GET("/v1/public/characters")
    suspend fun findAll(
        @Query("limit") limit: String = ApiConstants.MAX_RESULT,
        @Query("apikey") apiKey: String = ApiConstants.PUBLIC_KEY,
        @Query("ts") ts: String = ApiConstants.TIMESTAMP,
        @Query("hash") hash: String = ApiConstants.createHash(),
    ): ApiResponseDto
}