package pl.margoj.server.api.chat

import com.google.gson.annotations.SerializedName
import pl.margoj.server.api.utils.TimeUtils

data class ChatMessage @JvmOverloads constructor(
        @SerializedName("t") val text: String,
        @SerializedName("k") val type: Int? = null,
        @SerializedName("n") val nickname: String? = null,
        @SerializedName("nd") val target: String? = null,
        @SerializedName("i") val img: String? = null,
        @SerializedName("s") val style: String? = null,
        @SerializedName("ts") val timestamp: Double? = TimeUtils.getTimestampDouble()
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