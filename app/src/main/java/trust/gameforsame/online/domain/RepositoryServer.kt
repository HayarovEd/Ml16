package trust.gameforsame.online.domain

import game.cry.orwin.data.Resource
import trust.gameforsame.online.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}