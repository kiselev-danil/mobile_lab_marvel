package com.example.marvel.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.marvel.R

@Composable
fun CharacterScroll(modifier: Modifier = Modifier, characters: List<CharacterModel>, onCharacterSelect: (String)->Unit) {


    LazyRow(modifier = modifier
        .padding(start = 16.dp)
    ) {
        itemsIndexed(characters) { index, item ->
            CharacterPreview(
                modifier = Modifier.clickable { onCharacterSelect(item.id.toString()) },
                model = item
            )
            if (index < characters.lastIndex) {
                Divider(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 24.dp, start = 16.dp, end = 0.dp)
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
        stringResource(id = R.string.test_image_url)
    val model = CharacterModel(
        0,"TestMan", "Testers gonna test", previewImageUri
    )
    val list: List<CharacterModel> = listOf(model, model, model)
    CharacterScroll(Modifier.border(width = 1.dp, color = Color.Red), characters = list, onCharacterSelect = {})
}