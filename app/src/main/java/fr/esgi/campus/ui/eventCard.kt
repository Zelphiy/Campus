package fr.esgi.campus.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.esgi.campus.R
import fr.esgi.campus.data.Event

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = event.title,
                    modifier = Modifier.weight(1f)
                )
                Text(event.category)
            }
            Text(
                text = event.location ?: "Lieu à confirmer",
            )
            TextButton(
                onClick = {
                    onClick
                    Log.d("Voir", "${event.title} a été vue")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Voir ->",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
            Button(
                onClick = onFavoriteClick
            ) {
                Text(if (isFavorite) "★ Favori" else "☆ Ajouter aux favoris")
            }
            Button(
                enabled = event.capacity > 0,
                onClick = {
                    Log.d("Reservation", "${event.title} a été reservé")
                    onBook
                }
            ) {
                Text(stringResource(R.string.book))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventCardPreview() {
    val event1 = Event(
        id = 1,
        title = "Conférence Jetpack Compose",
        category = "TECH",
        location = "Salle 204",
        capacity = 32
    )

    val eventWithLongTitleAndNoLocation = Event(
        id = 1,
        title = "Conférence Kotlin sur les coroutines avec l'intervenant Frederic Bellano",
        category = "TECH",
        location = null,
        capacity = 32
    )
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        EventCard(
            event = event1,
            onClick = {},
            onBook = {},
            isFavorite = false,
            onFavoriteClick = {}
        )
        EventCard(
            event = eventWithLongTitleAndNoLocation,
            onClick = {},
            onBook = {},
            isFavorite = false,
            onFavoriteClick = {}
        )
    }
}
