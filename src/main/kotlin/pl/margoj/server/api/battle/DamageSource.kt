package pl.margoj.server.api.battle

/**
 * Reprezentuje cokolwiek co moze zadac obrazenia
 */
interface DamageSource
{
    /**
     * Nazwa tego damage source
     */
    val damageSourceName: String
}