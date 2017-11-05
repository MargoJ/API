package pl.margoj.server.api.entity

import pl.margoj.server.api.battle.Battle
import pl.margoj.server.api.battle.BattleStats
import pl.margoj.server.api.battle.DamageSource
import pl.margoj.server.api.player.Gender
import java.util.Date

interface LivingEntity : Entity, DamageSource
{
    /**
     * Ilość punktów życia entity
     */
    var hp: Int

    /**
     * Procenotwa ilość zdrowia entity
     */
    val healthPercent: Int

    /**
     * Poziom entity
     */
    val level: Int

    /**
     * Płeć entity
     */
    val gender: Gender

    /**
     * Statystyki entity
     */
    val stats: BattleStats

    /**
     * Walka w jakiej znajduje sie entity
     */
    val currentBattle: Battle?

    /**
     * Data respawnu entity, może być nullem gdy entity jest żywe
     */
    val deadUntil: Date?

    /**
     * Czy entity jest martwy?
     */
    val isDead: Boolean

    /**
     * Zadaje [amount] obrażeń temu entity
     *
     * @param damageSource źródło obrażeń
     */
    fun damage(amount: Int, damageSource: DamageSource?)

    /**
     * Zabiaj entity na domyślną ilośc czasu
     *
     * @param damageSource źródło obrażeń
     */
    fun kill(damageSource: DamageSource?)
}