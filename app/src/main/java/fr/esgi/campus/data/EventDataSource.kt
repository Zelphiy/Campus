package fr.esgi.campus.data

object FakeEvents {
    val list = listOf(
        Event(
            id = 1,
            title = "Introduction à Jetpack Compose et Material 3",
            category = "ANDROID",
            location = "Amphithéâtre A",
            capacity = 150,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec molestie aliquet nunc, eget vehicula turpis efficitur pretium. Nullam euismod felis eu consectetur rhoncus. Morbi fermentum ac velit et pellentesque. Integer non massa sed turpis condimentum cursus nec in urna. Proin porttitor efficitur quam, ut tincidunt lectus sollicitudin in. Sed risus sapien, pretium nec hendrerit quis, vestibulum a nisi. Vestibulum eget dictum diam, non pulvinar mauris. Vestibulum nec purus in massa maximus congue non interdum magna. Cras dignissim est at ipsum pretium facilisis. Nulla enim augue, fermentum sit amet malesuada nec, fermentum vel magna. Aenean viverra eu nisl ut porta."
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