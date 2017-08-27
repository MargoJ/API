package pl.margoj.server.api.utils

import com.google.gson.*
import java.lang.reflect.Type

abstract class CharEnumJsonAdapter<T> : JsonSerializer<T>, JsonDeserializer<T>
{
    abstract fun getId(type: T): Char

    abstract fun fromId(id: Char): T?

    override fun serialize(src: T?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement?
    {
        if(src == null)
        {
            return null
        }
        else
        {
            return JsonPrimitive(this.getId(src))
        }
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): T?
    {
        if (json == null || !json.isJsonPrimitive || !json.asJsonPrimitive.isString)
        {
            return null
        }

        val str = json.asString
        return if (str.length != 1) null else this.fromId(str[0])
    }

    companion object
    {
        @JvmStatic
        fun <T> simple(toId: (T) -> Char, fromId: (Char) -> T?): CharEnumJsonAdapter<T>
        {
            return object : CharEnumJsonAdapter<T>()
            {
                override fun getId(type: T): Char
                {
                    return toId(type)
                }

                override fun fromId(id: Char): T?
                {
                    return fromId(id)
                }
            }
        }
    }
}