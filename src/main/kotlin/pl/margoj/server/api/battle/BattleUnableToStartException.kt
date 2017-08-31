package pl.margoj.server.api.battle

import pl.margoj.server.api.entity.Entity

/**
 * Wyjątek wywoływany gdy walka nie może być rozpoczęta
 */
class BattleUnableToStartException(

        /**
         * Lista entity przez jakie nie mozna rozpocząć walki oraz powody
         */
        val causeEntities: Map<Entity, Cause>

) : RuntimeException()
{
    private val string: String

    init
    {
        val builder = StringBuilder("battle unable to start: \n")
        this.causeEntities.forEach { builder.append(it.key).append(", cause: ").append(it.value).append("\n") }
        string = builder.toString()
    }

    override fun toString(): String = string

    enum class Cause
    {
        /**
         * Gracz jest wylogowany
         */
        PLAYER_IS_OFFLINE,

        /**
         * Entity jest martwe,
         */
        ENTITY_IS_DEAD,

        /**
         * Entity jest w trakcie innej walki
         */
        ENTITY_IN_BATTLE
    }
}