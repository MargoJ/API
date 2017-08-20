package pl.margoj.server.api.sync

/**
 * Builder dla tasków
 */
interface TaskBuilder
{
    /**
     * Wykonuj task synchronicznie
     */
    fun sync(): TaskBuilder

    /**
     * Wykonuj task asynchronicznie
     */
    fun async(): TaskBuilder

    /**
     * [Runnable] ktore task ma wykonywac
     */
    fun withRunnable(runnable: Runnable): TaskBuilder

    /**
     * [action] jakie task ma wykonywac
     */
    fun withRunnable(action: () -> Unit): TaskBuilder

    /**
     * Opóźnij o [ticks] ticków
     */
    fun delay(ticks: Int): TaskBuilder

    /**
     * Opóźnij o [seconds] sekind
     */
    fun delaySeconds(seconds: Int): TaskBuilder

    /**
     * Powtarzaj co [ticks] ticków
     */
    fun repeat(ticks: Int): TaskBuilder

    /**
     * Powtarzaj co [seconds] sekund
     */
    fun repeatSeconds(seconds: Int): TaskBuilder

    /**
     * Dodaje taska do schedulera
     *
     * @return id taska
     */
    fun submit(): Int
}