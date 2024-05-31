package com.example.marvel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvel.R
import com.example.marvel.model.CharacterModel
import com.example.marvel.service.CharacterService
import com.example.marvel.ui.theme.MarvelAppTheme
import com.example.marvel.util.MockObjects
import kotlinx.coroutines.runBlocking

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    modelId: String,
    onNavigateBack: () -> Unit,
    characterService: CharacterService
) {
    val model: CharacterModel
    runBlocking {
        model = characterService.findCharacterById(modelId)?: throw Exception("Cannot obtain character with such id")
    }

    Box {
        Box(modifier = modifier) {
            AsyncImage(
                model = model.img,
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentDescription = stringResource(R.string.character_image_placeholder)
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, bottom = 18.dp)

            ) {
                IconButton(modifier = Modifier.padding(top = 16.dp), onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.size(
                            width = 32.dp, height = 32.dp
                        ),
                        contentDescription = stringResource(R.string.arrow_back)
                    )
                }
                Column(
                    horizontalAlignment = AbsoluteAlignment.Left,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = 16.dp
                        )
                ) {
                    Text(
                        text = model.name,
                        color = MarvelAppTheme.TextColors.white,
                        fontWeight = MarvelAppTheme.TextStyle.Bold_Character_Name.fontWeight,
                        fontSize = MarvelAppTheme.TextStyle.Bold_Character_Name.fontSize,
                        modifier = Modifier
                    )
                    Spacer(
                        modifier = Modifier.size(
                            width = 12.dp, height = 18.dp
                        )
                    )
                    Text(
                        text = model.catchPhrase,
                        color = MarvelAppTheme.TextColors.white,
                        fontWeight = MarvelAppTheme.TextStyle.Bold_Character_Phrase.fontWeight,
                        fontSize = MarvelAppTheme.TextStyle.Bold_Character_Phrase.fontSize,
                        modifier = Modifier
                    )
                }

            }

        }
    }
}

//@Composable
//@Preview
//fun PreviewCharacterScreen() {
//    val previewImageUri = stringResource(id = R.string.test_image_url)
//    val model = CharacterModel(
//        "TestMan", "Testers gonna test", img = previewImageUri
//    )
//    CharacterScreen(modelId = "3", onNavigateBack = {})
//}