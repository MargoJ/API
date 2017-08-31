package pl.margoj.server.api.events.battle

import pl.margoj.server.api.battle.Battle
import pl.margoj.server.api.battle.BattleTeam

/**
 * Event wywoływany gdy walka się kończy
 */
open class BattleFinishedEvent(
        override val battle: Battle,

        /**
         * Czy walka została rozstzygnięta?
         */
        val hasWinner: Boolean,

        /**
         * Zwycięska drużyna
         */
        val winnerTeam: BattleTeam?,

        /**
         * Zwycięska drużyna
         */
        val loserTeam: BattleTeam?
) : BattleEvent()
{
    override val async: Boolean = false
}