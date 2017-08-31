package pl.margoj.server.api.battle

import pl.margoj.server.api.entity.Entity

/**
 * Reprezentuje walkę
 */
interface Battle
{
    /**
     * Czy walka została już rozpoczęta?
     */
    val started: Boolean

    /**
     * Czy walka została już zakończona?
     */
    val finished: Boolean

    /**
     * Czy walka trwa?
     */
    val ongoing: Boolean get() = this.started && !this.finished

    /**
     * Lista wszystkich uczestników walki
     */
    val participants: List<Entity>

    /**
     * Lista osób w drużynie pierwszej
     */
    val teamA: List<Entity>

    /**
     * Lista osób w drużynie drugiej
     */
    val teamB: List<Entity>

    /**
     * Pobiera zwyciężce, lub zwraca nulla gdy walka jest nierozsztygnięta
     */
    val winner: BattleTeam?

    /**
     * Pobiera przegranego, lub zwraca nulla gdy walka jest nierozsztygnięta
     */
    val loser:  BattleTeam?

    /**
     * Pobiera wszystkich graczy z podanej drużnyny
     */
    fun getTeamParticipants(team: BattleTeam): List<Entity>
}