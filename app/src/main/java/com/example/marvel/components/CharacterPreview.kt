package com.example.marvel.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvel.R
import com.example.marvel.model.CharacterModel

@Composable
fun CharacterPreview(modifier: Modifier = Modifier, model: CharacterModel) {
    Box(modifier = modifier) {
        AsyncImage(
            model = model.img,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = stringResource(R.string.character_image_placeholder)
        )
    }
}

@Preview(showSystemUi = true, backgroundColor = 0x1f000F0F, showBackground = true)
@Composable
fun PreviewCharacterPreview() {
    val previewImageUri = "https://i.ytimg.com/vi/QLBRYAPRBy4/sddefault.jpg"
    val model = CharacterModel(
        "TestMan",
        "Testers gonna test",
        img = previewImageUri
    )
    CharacterPreview(
        Modifier.border(width = 1.dp, color = Color.Red),
        model
    )
}