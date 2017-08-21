package pl.margoj.server.api.chat

import com.google.gson.annotations.SerializedName
import pl.margoj.server.api.chat.ChatMessage.Type
import pl.margoj.server.api.utils.TimeUtils
import java.math.BigDecimal

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
        @SerializedName("k") val type: Int? = null,

        /**
         * Nazwa gracza który wysłał daną wiadomośc, może być nullem
         */
        @SerializedName("n") val nickname: String? = null,

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
        @SerializedName("ts") val timestamp: BigDecimal? = BigDecimal.valueOf(TimeUtils.getTimestampDouble())
)
{
    companion object Type
    {
        const val TYPE_GLOBAL = 0
        const val TYPE_CLAN = 1
        const val TYPE_TEAM = 2
        const val TYPE_PRIV = 3
    }
}