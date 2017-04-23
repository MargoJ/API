package pl.margoj.server.api.player

import com.google.gson.*
import java.lang.reflect.Type

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
        fun getById(id: Char): Profession?
        {
            return Profession.values().firstOrNull { it.id == id }
        }
    }

    class JsonAdapter : JsonSerializer<Profession>, JsonDeserializer<Profession>
    {
        override fun serialize(src: Profession?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? = if (src == null) null else JsonPrimitive(src.id)

        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Profession?
        {
            if (json == null || !json.isJsonPrimitive || !json.asJsonPrimitive.isString)
            {
                return null
            }
            val str = json.asString
            return if (str.length != 1) null else Profession.getById(str[0])
        }
    }
}