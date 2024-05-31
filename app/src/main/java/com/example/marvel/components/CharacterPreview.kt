package com.example.marvel.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvel.R
import com.example.marvel.model.CharacterModel
import com.example.marvel.ui.theme.MarvelAppTheme

@Composable
fun CharacterPreview(modifier: Modifier = Modifier, model: CharacterModel) {
    Box(modifier = modifier
        .padding(vertical = 8.dp)
        .wrapContentSize()
    ) {
        AsyncImage(
            model = model.img,
            modifier = modifier
                .fillMaxHeight()
//                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.character_image_placeholder)
        )
        Text(
            text = model.name,
            color = MarvelAppTheme.TextColors.white,
            fontWeight = MarvelAppTheme.TextStyle.Bold_Character_Name.fontWeight,
            fontSize = MarvelAppTheme.TextStyle.Bold_Character_Name.fontSize,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 18.dp, bottom = 48.dp)
        )
    }
}

@Preview(showSystemUi = true, backgroundColor = 0x1f000F0F, showBackground = true)
@Composable
fun PreviewCharacterPreview() {
    val previewImageUri = stringResource(id = R.string.test_image_url)
    val model = CharacterModel(
        0,
        "TestMan",
        "Testers gonna test",
        img = previewImageUri
    )
    CharacterPreview(
        Modifier.border(width = 1.dp, color = Color.Red),
        model
    )
}