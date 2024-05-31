package com.example.marvel.util

import com.example.marvel.model.CharacterModel

object MockObjects {
    val map: Set<CharacterModel> = hashSetOf(
        CharacterModel(
            0, "IronMan", "Nobody wants him\n" +
                    "He just stares at the world\n" +
                    "Planning his vengeance\n" +
                    "That he will soon unfold\n", img = "https://iili.io/JMnuDI2.png"
        ),
        CharacterModel(
            1,
            "Das Hamster",
            "Born to die",
            img = "https://bluemountainhay.b-cdn.net/wp-content/uploads/Learning-Center/Timothy-Hay-for-Hamsters/ricky-kharawala-adK3Vu70DEQ-unsplash.jpg"
        ),
        CharacterModel(
            2,
            "Deadpool",
            "Please don’t make the super\u2028suit green...or animated!",
            img = "https://iili.io/JMnAfIV.png"
        ),
        CharacterModel(3, "Spider Man", "In iron suit", img = "https://iili.io/JMnuyB9.png"),
    )

    fun findCharacterByName(name: String): CharacterModel? {
        for (char in map) {
            if (char.name.equals(name)) {
                return char;
            }
        }
        return null;
    }

}