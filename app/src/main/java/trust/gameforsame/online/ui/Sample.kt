package trust.gameforsame.online.ui

import android.content.pm.ActivityInfo
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import trust.gameforsame.online.ui.StateOrientation.Auto
import trust.gameforsame.online.ui.StateOrientation.Horizontal
import trust.gameforsame.online.ui.StateOrientation.Vertical
import trust.gameforsame.online.domain.model.StatusApplication.Loading
import trust.gameforsame.online.domain.model.StatusApplication.NoConnect
import trust.gameforsame.online.domain.model.StatusApplication.Web

@Composable
fun Sample(
    activity: ComponentActivity,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    when (val currentState = state.value.statusApplication) {
        Loading -> LoadingScreen()
        NoConnect -> {
            NoConnectScreen()
        }

        is Web -> {
            if (currentState.stateOrientation !is Auto)
            SetScreenOrientation(
                activity = activity,
                stateOrientation = currentState.stateOrientation
            )
            WebViewScreen(url = currentState.url)
        }
    }
}

@Composable
fun SetScreenOrientation(
    activity: ComponentActivity,
    stateOrientation: StateOrientation
) {
    when (stateOrientation) {
        Vertical  -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Horizontal -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
   /* if (orientation=="1") {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    } else {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }*/
}