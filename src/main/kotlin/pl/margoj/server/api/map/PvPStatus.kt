package pl.margoj.server.api.map

/**
 * Reprezentuje status PvP danej mapy
 */
enum class PvPStatus
{
    /**
     * PvP jest kompletnie wyłączone ("zielone mapki")
     */
    NO_PVP,

    /**
     * PvP jest dostępne tylko za zgodą obu graczy ("żółte mapki")
     */
    CONDITIONAL,

    /**
     * To samo co CONDITIONAL ale wyniki gier rozgłaszane są na chatcie a czas odnowienia jest skrócony do 1 sekundy (areny)
     */
    ARENAS,

    /**
     * PvP jest dostępnę nawet bez zgody drugiej strony ("czerwone mapki")
     */
    UNCONDITIONAL
}