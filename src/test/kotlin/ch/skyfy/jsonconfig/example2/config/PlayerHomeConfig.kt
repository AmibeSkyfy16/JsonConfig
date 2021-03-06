package ch.skyfy.jsonconfig.example2.config

import ch.skyfy.jsonconfig.Defaultable
import ch.skyfy.jsonconfig.Validatable
import kotlinx.serialization.Serializable

@Serializable
data class PlayersHomesConfig(var players: MutableList<Player>) : Validatable {

    override fun validateImpl(errors: MutableList<String>) {
        players.forEach { it.validateImpl(errors) } // validation for player object
    }

}

class DefaultPlayerHomeConfig : Defaultable<PlayersHomesConfig> {
    override fun getDefault(): PlayersHomesConfig = PlayersHomesConfig(mutableListOf())
}