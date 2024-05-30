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
import com.example.marvel.ui.navigation.NavGraph
import com.example.marvel.ui.theme.MarvelAppTheme
import com.example.marvel.ui.theme.MarvelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MarvelAppTheme.BgColors.primary
                ) {
                    NavGraph()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    ChooseYourHeroScreen(modifier, {})
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MarvelTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MarvelAppTheme.BgColors.primary
        ) {
            ChooseYourHeroScreen(Modifier, {})
        }
    }
}