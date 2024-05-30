package com.example.marvel.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.marvel.R
import com.example.marvel.model.CharacterModel
import com.example.marvel.ui.theme.BackgroundBlack
import com.example.marvel.ui.theme.MarvelAppTheme
import com.example.marvel.util.MockObjects

@Composable
fun ChooseYourHeroScreen(modifier: Modifier = Modifier, onCharacterSelect: (String)->Unit) {
    val list: List<CharacterModel> = MockObjects.map.toList()

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = modifier)
        Column(
            modifier = modifier.padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.marvel_logo),
                contentDescription = "There must be poster",
                modifier = modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.choose_hero_screen_text),
                modifier = modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                color = MarvelAppTheme.TextColors.white,
                fontSize = MarvelAppTheme.TextStyle.Bold_48.fontSize,
                fontWeight = MarvelAppTheme.TextStyle.Bold_48.fontWeight

            )
            CharacterScroll(modifier, list, onCharacterSelect)
        }
        Spacer(modifier = modifier)
    }


}

@Preview(showSystemUi = true, backgroundColor = 0xFF2C272B, showBackground = true)
@Composable
fun PreviewChooseYourHeroScreen() {
    ChooseYourHeroScreen(onCharacterSelect = {})
}
