package pl.margoj.server.api.player

import com.google.gson.*
import java.lang.reflect.Type

/**
 * Reprezentuje profesje gracza w grze
 */
enum class Profession(val id: Char)
{
    /**
     * Wojownik
     */
    WARRIOR('w'),

    /**
     * Paladyn
     */
    PALADIN('p'),

    /**
     * Mag
     */
    MAGE('m'),

    /**
     * Łowca
     */
    HUNTER('h'),

    /**
     * Tropicie
     */
    TRACKER('t'),

    /**
     * Tancerz ostrzy
     */
    BLADE_DANCER('b');

    companion object
    {
        @JvmStatic
        fun getById(id: Char): Profession?
        {
            return Profession.values().firstOrNull { it.id == id }
        }
    }
}