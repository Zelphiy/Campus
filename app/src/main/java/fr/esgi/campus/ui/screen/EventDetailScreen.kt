package fr.esgi.campus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import fr.esgi.campus.data.Event
import fr.esgi.campus.data.FakeEvents
import fr.esgi.campus.ui.theme.CampusTheme

class EventDetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun EventDetail(
    event: Event,
    onBook: () -> Unit
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        Text(text = stringResource(R.string.event_title_label, event.title))
        Text(text = stringResource(R.string.event_location_label, event.location ?: "Lieu à confirmer"))
        Text(text = stringResource(R.string.event_description_label, event.description))
        Text(pluralStringResource(R.plurals.available_seats, event.capacity, event.capacity))
        Button(
            onClick = onBook,

        ) {
            Text(stringResource(R.string.book))
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun EventDetailPreviewLightDark() {
    EventDetail(
        event = FakeEvents.list.first(),
        onBook = {}
    )
}

@Preview
@PreviewFontScale
@Composable
private fun EventDetailPreviewFontScale() {
    EventDetail(
        event = FakeEvents.list.first(),
        onBook = {}
    )
}

@Preview
@PreviewScreenSizes
@Composable
private fun EventDetailPreviewScreenSizes() {
    EventDetail(
        event = FakeEvents.list.first(),
        onBook = {}
    )
}
