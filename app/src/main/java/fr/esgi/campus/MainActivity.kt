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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun EventListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(FakeEvents.list) { event ->
            EventCard(
                event = event,
                onClick = {},
                onBook = {}
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