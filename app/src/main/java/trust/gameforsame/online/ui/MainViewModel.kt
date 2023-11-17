package trust.gameforsame.online.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import game.cry.orwin.data.Resource.Success
import game.cry.orwin.data.Resource.Error
import trust.gameforsame.online.ui.StateOrientation.Auto
import trust.gameforsame.online.ui.StateOrientation.Horizontal
import trust.gameforsame.online.ui.StateOrientation.Vertical
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import trust.gameforsame.online.domain.RepositoryServer
import trust.gameforsame.online.domain.model.StatusApplication.NoConnect
import trust.gameforsame.online.domain.model.StatusApplication.Web

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositoryServer: RepositoryServer,
) : ViewModel() {

    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            when (val result = repositoryServer.getDataDb()) {
                is Error -> {
                    _state.value.copy(
                        statusApplication = NoConnect
                    )
                        .updateStateUI()
                }

                is Success -> {
                    val url = result.data?.appConfig?.showedIconPrimary
                    val orientation = result.data?.appConfig?.namePrimary
                    if (url == null) {
                        _state.value.copy(
                            statusApplication = NoConnect
                        )
                            .updateStateUI()
                    } else {
                        Log.d("ASDFG", "ort - $orientation")
                        _state.value.copy(
                            statusApplication = Web(
                                url = url,
                                stateOrientation = setStateOrientation(
                                    orientation
                                )
                            )
                        )
                            .updateStateUI()
                    }
                }
            }

        }
    }

    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }

    private fun setStateOrientation(stringState: String?): StateOrientation {
        return when (stringState) {
            "2" -> Horizontal
            "1" -> Vertical
            "3" -> Auto
            else -> Vertical
        }
    }
}