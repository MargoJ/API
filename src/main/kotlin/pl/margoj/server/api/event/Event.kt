package pl.margoj.server.api.event

/**
 * Pojedyńcze zdarzenie
 */
interface Event
{
    /**
     * Czy event może być wykonywany asynchronicznie
     */
    val async: Boolean
}