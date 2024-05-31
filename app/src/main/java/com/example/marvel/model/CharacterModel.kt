package com.example.marvel.model

import android.media.Image
import coil.compose.AsyncImage


data class CharacterModel(val id: Int?, val name:String, val catchPhrase: String, val img: String) {
}