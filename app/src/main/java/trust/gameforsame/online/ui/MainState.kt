package trust.gameforsame.online.ui

import trust.gameforsame.online.domain.model.StatusApplication


data class MainState(
    val statusApplication: StatusApplication = StatusApplication.Loading/*Web(url = "https://ya.ru/", offerName = "Offer")*/,
)
