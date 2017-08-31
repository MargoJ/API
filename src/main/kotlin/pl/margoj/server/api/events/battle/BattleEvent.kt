package pl.margoj.server.api.events.battle

import pl.margoj.server.api.battle.Battle
import pl.margoj.server.api.event.Event

/**
 * Podstawowa klasa wszystkich eventów walki
 */
abstract class BattleEvent : Event
{
    /**
     * Instancja walki której ten event dotyczy
     */
    abstract val battle: Battle
}