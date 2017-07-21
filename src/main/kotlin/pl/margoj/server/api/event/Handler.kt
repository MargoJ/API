package pl.margoj.server.api.event

/**
 * Adnotacja która musi być umieszczona nad metodą EventHandlera
 * aby ta metoda została zarejestrowana jako listener
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Handler(
        /**
         * Priorytet eventu
         */
        val prority: Byte = 0
)