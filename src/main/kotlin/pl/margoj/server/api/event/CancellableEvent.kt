package pl.margoj.server.api.event

/**
 * Pojedyńcze zdarzenie które może być anulowane
 */
interface CancellableEvent : Event
{
    var cancelled: Boolean
}