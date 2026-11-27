package fr.esgi.campus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.esgi.campus.data.FakeEvents
import fr.esgi.campus.ui.EventCard
import fr.esgi.campus.ui.theme.CampusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val capacity = "douze".toIntOrNull() ?: 0;
        // Etape 2
        // RuntimeException: Unable to start activity
        // NumberFormatException: For input string: "douze"
        // Etape 4
        val TAG = "Campus"
        Log.d(TAG, "Places : $capacity")
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        EventListScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampusTheme {
        Greeting("Android")
    }
}

@Composable
fun EventHeader(title: String, category: String, location: String? = null) {
    Row(horizontalArrangement = Arrangement.spacedBy(space = 8.dp)) {
        Text(
            text = title
        )
        Text(category)
        Text(location ?: "Lieu Ã confirmer")
    }
}

@Preview(showBackground = true)
@Composable
private fun EventHeaderPreview() {
    EventHeader(title = "Android", "Tech", null)
}

@Composable
fun SearchField(state: TextFieldState, modifier: Modifier = Modifier) {
    TextField(
        label = { Text("Rechercher") },
        state = state
    )
}

@Composable
fun EventListScreen(modifier: Modifier = Modifier) {
    var favoriteIds by rememberSaveable { mutableStateOf(listOf<Int>()) }
    val categories = FakeEvents.list.map { it.category }.distinct()
    val queryState = rememberTextFieldState()
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    val visibleElements = FakeEvents.list.filter {
        it.title.contains(queryState.text, ignoreCase = true)
            &&
        (selectedCategory == null || it.category == selectedCategory)

    }
    SearchField(state = queryState)
    CategoryRow(
        categories = categories,
        onCategorySelect = {category -> selectedCategory = if (selectedCategory == category) null else category},
        selected = selectedCategory
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { Text("Mes favoris : ${favoriteIds.size}") }
        items(visibleElements) { event ->
            val isFavorite = event.id in favoriteIds
            EventCard(
                event = event,
                onClick = {},
                onBook = {},
                isFavorite = isFavorite,
                onFavoriteClick = {
                    favoriteIds = if (isFavorite) favoriteIds - event.id else favoriteIds + event.id
                }
            )
        }
    }
}

@Composable
fun CategoryRow(categories: List<String>, onCategorySelect: (String) -> Unit, selected: String?) {
    LazyRow {
        items(categories) { category ->
            FilterChip(
                selected = category == selected,
                onClick = { onCategorySelect(category) },
                label = { Text(category) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    CampusTheme {
        EventListScreen()
    }
}