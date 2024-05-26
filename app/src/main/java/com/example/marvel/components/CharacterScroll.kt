package com.example.marvel.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel.model.CharacterModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CharacterScroll(modifier: Modifier = Modifier, characters: List<CharacterModel>) {


    LazyRow(modifier = modifier
        .padding(horizontal = 24.dp)
    ) {
        itemsIndexed(characters) { index, item ->
            CharacterPreview(modifier = Modifier, model = item)
            if (index < characters.lastIndex) {
                Divider(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(horizontal = 38.dp, vertical = 24.dp)
                        .border(width = 1.dp, color = Color.Green)
                )
            }
        }
    }
}


@Preview(showSystemUi = true, backgroundColor = 0x1f000F0F, showBackground = true)
@Composable
fun PreviewCharacterScroll() {
    val previewImageUri =
        "https://i.ytimg.com/vi/QLBRYAPRBy4/sddefault.jpg"
    val model = CharacterModel(
        "TestMan", "Testers gonna test", previewImageUri
    )
    val list: List<CharacterModel> = listOf(model, model, model)
    CharacterScroll(Modifier.border(width = 1.dp, color = Color.Red), characters = list)
}