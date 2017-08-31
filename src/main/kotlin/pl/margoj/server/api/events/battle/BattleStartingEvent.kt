package pl.margoj.server.api.events.battle

import pl.margoj.server.api.battle.Battle
import pl.margoj.server.api.event.CancellableEvent

/**
 * Event wywoływany gdy rozpoczyna się nowa walka
 */
open class BattleStartingEvent(override val battle: Battle) : BattleEvent(), CancellableEvent
{
    /**
     * Czy zablokować możliwość rozpoczęcia tej walki?
     */
    override var cancelled: Boolean = false

    override val async: Boolean = false
}