package trust.gameforsame.online.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import trust.gameforsame.online.ui.theme.baseBackground

@Composable
fun NoConnectScreen(
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(baseBackground)
    ) {
        Text(
            modifier = modifier
                .align(alignment = Alignment.Center),
            text = "No connect",
            fontSize = 30.sp)
    }
}