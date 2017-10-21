package pl.margoj.server.api.player

/**
 * Reprezentuje range gracza
 */
enum class PlayerRank
{
    /**
     * Zwykły użytkownik
     */
    USER,

    /**
     * Mistrz gry
     */
    GAME_MASTER,

    /**
     * Super mistrz gry
     */
    SUPER_GAME_MASTER,

    /**
     * Administrator
     */
    ADMINISTRATOR
}