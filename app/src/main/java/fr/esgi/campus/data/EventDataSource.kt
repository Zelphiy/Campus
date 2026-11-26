package fr.esgi.campus.data

object FakeEvents {
    val list = listOf(
        Event(
            id = 1,
            title = "Introduction à Jetpack Compose et Material 3",
            category = "ANDROID",
            location = "Amphithéâtre A",
            capacity = 150
        ),
        Event(
            id = 2,
            title = "Architecture Clean & MVI dans une application moderne",
            category = "ARCHITECTURE",
            location = null,
            capacity = 80
        ),
        Event(
            id = 3,
            title = "Optimisation des performances avec les coroutines Kotlin",
            category = "KOTLIN",
            location = "Salle 302",
            capacity = 60
        ),
        Event(
            id = 4,
            title = "L'IA générative sur mobile avec Gemini Nano et LiteRT",
            category = "AI",
            location = "Salle 203",
            capacity = 0
        ),
        Event(
            id = 5,
            title = "Sécurité et bonnes pratiques dans les applications Android",
            category = "SECURITY",
            location = "Salle 105",
            capacity = 50
        )
    )
}