package game.cry.orwin.data

import game.cry.orwin.data.Resource.Error
import game.cry.orwin.data.Resource.Success
import trust.gameforsame.online.domain.RepositoryServer
import trust.gameforsame.online.domain.model.basedto.BaseDto
import javax.inject.Inject
import trust.gameforsame.online.data.ApiServer

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseDto> {
        return try {
            val folder = apiServer.getDataDb()
            Success(
                data = folder
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Error(e.message ?: "An unknown error")
        }
    }
}