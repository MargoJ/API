package pl.margoj.server.api.chat

import com.google.gson.annotations.SerializedName
import pl.margoj.server.api.chat.ChatMessage.Type
import pl.margoj.server.api.utils.TimeUtils
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicInteger

/**
 * Reprezentuje wiadomość jaka może być wysłana do gracza
 */
data class ChatMessage @JvmOverloads constructor(
        /**
         * Tekst, może zawierać kod HTML
         */
        @SerializedName("t") val text: String,

        /**
         * [Type] wiadomości
         */
        @SerializedName("k") val type: Int = 0,

        /**
         * Nazwa gracza który wysłał daną wiadomośc
         */
        @SerializedName("n") val nickname: String = "",

        /**
         * Cel wiadomości, tylko w wiadomośćiach prywatnych
         */
        @SerializedName("nd") val target: String? = null,

        /**
         * ?
         */
        @SerializedName("i") val img: String? = null,

        /**
         * Styl CSS wiadomości
         */
        @SerializedName("s") val style: String? = null,

        /**
         * Data wysłania wiadomośći
         */
        @SerializedName("ts") val timestamp: BigDecimal = BigDecimal.valueOf(TimeUtils.getTimestampDouble())
)
{
    companion object Type
    {
        const val TYPE_GLOBAL = 0
        const val TYPE_CLAN = 1
        const val TYPE_TEAM = 2
        const val TYPE_PRIV = 3

        private val counter = AtomicInteger()
    }

    val id = counter.incrementAndGet()

    override fun equals(other: Any?): Boolean
    {
        return other is ChatMessage && other.id == this.id
    }

    override fun hashCode(): Int
    {
        return this.id
    }
}