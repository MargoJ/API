package pl.margoj.server.api.events.battle

import pl.margoj.server.api.battle.Battle

/**
 * Event wywoływany gdy walka została rozpoczęta, gdy ten event jest wywoływany
 * nie można już zablokować rozpoczęcia walki
 */
open class BattleStartedEvent(override val battle: Battle) : BattleEvent()
{
    override val async: Boolean = false
}