package com.example.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.components.ChooseYourHeroScreen
import com.example.marvel.components.ErrorScreen
import com.example.marvel.dto.ApiResponseDto
import com.example.marvel.dto.CharacterDto
import com.example.marvel.model.CharacterModel
import com.example.marvel.repository.MarvelApiRepository
import com.example.marvel.service.CharacterService
import com.example.marvel.service.MarvelService
import com.example.marvel.ui.navigation.NavGraph
import com.example.marvel.ui.theme.MarvelAppTheme
import com.example.marvel.ui.theme.MarvelTheme
import com.example.marvel.util.ApiConstants
import com.example.marvel.util.DtoModelMapper
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
            val api = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(MarvelApiRepository::class.java)
            val marvelService = MarvelService(marvelApi = api)
            var isError = false
            val characterService = CharacterService(marvelService)
            var characters: List<CharacterModel> = listOf()
            runBlocking {
                characterService.findAllCharacters()?.let { ch -> characters = ch } ?: {
                    isError = true
                }
            }

            MarvelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MarvelAppTheme.BgColors.primary
                ) {
                    if(isError) {
                        ErrorScreen()
                    }
                    else {
                        NavGraph(characters = characters, characterService = characterService)
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    ChooseYourHeroScreen(modifier, {})
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MarvelTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MarvelAppTheme.BgColors.primary
//        ) {
//            ChooseYourHeroScreen(Modifier, {})
//        }
//    }
//}