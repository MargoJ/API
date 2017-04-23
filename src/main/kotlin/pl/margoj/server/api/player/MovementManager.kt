package pl.margoj.server.api.player

import pl.margoj.server.api.map.Location

interface MovementManager
{
    /**
     * Kierunek w który aktualnie patrzy się gracz
     */
    val playerDirection: Int

    /**
     * Lokacja w jakiej gracz się znajduje
     */
    val location: Location
}