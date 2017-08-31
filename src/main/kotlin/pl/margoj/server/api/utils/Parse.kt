package pl.margoj.server.api.utils

object Parse
{
    @JvmStatic
    @JvmOverloads
    fun parseByte(value: String?, radix: Int = 10): Byte?
    {
        if (value == null || value.isEmpty() || value.length > 4)
        {
            return null
        }

        val output = parseInt(value, radix)
        return if (output == null || output > Byte.MAX_VALUE || output < Byte.MIN_VALUE) null else output.toByte()
    }

    @JvmStatic
    @JvmOverloads
    fun parseShort(value: String?, radix: Int = 10): Short?
    {
        if (value == null || value.isEmpty() || value.length > 6)
        {
            return null
        }

        val output = parseInt(value, radix)
        return if (output == null || output > Short.MAX_VALUE || output < Short.MIN_VALUE) null else output.toShort()
    }

    @JvmStatic
    @JvmOverloads
    fun parseInt(value: String?, radix: Int = 10): Int?
    {
        if (value == null || value.isEmpty() || value.length > 11 || radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
        {
            return null
        }

        var limit = -Integer.MAX_VALUE
        var result = 0
        var negative = false
        var i = 0
        val length = value.length
        val multmin: Int
        var digit: Int

        val firstChar = value[0]
        if (firstChar < '0')
        {
            if (firstChar == '-')
            {
                negative = true
                limit = Integer.MIN_VALUE
            }
            else if (firstChar != '+')
            {
                return null
            }

            if (length == 1)
            {
                return null
            }
            i++
        }
        multmin = limit / radix
        while (i < length)
        {
            digit = Character.digit(value[i++], radix)
            if (digit < 0)
            {
                return null
            }
            if (result < multmin)
            {
                return null
            }
            result *= radix
            if (result < limit + digit)
            {
                return null
            }
            result -= digit
        }
        return if (negative) result else -result
    }

    @JvmStatic
    @JvmOverloads
    fun parseLong(value: String?, radix: Int = 10): Long?
    {
        if (value == null || value.isEmpty() || value.length > 20 || radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
        {
            return null
        }

        var limit = -Long.MAX_VALUE
        var result: Long = 0
        var negative = false
        var i = 0
        val length = value.length
        val multmin: Long
        var digit: Int

        val firstChar = value[0]
        if (firstChar < '0')
        {
            if (firstChar == '-')
            {
                negative = true
                limit = Long.MIN_VALUE
            }
            else if (firstChar != '+')
            {
                return null
            }

            if (length == 1)
            {
                return null
            }
            i++
        }
        multmin = limit / radix
        while (i < length)
        {
            digit = Character.digit(value[i++], radix)
            if (digit < 0)
            {
                return null
            }
            if (result < multmin)
            {
                return null
            }
            result *= radix.toLong()
            if (result < limit + digit)
            {
                return null
            }
            result -= digit.toLong()
        }
        return if (negative) result else -result
    }

    @JvmStatic
    fun parseChar(value: String?): Char?
    {
        return if (value != null && value.length == 1) value[0] else null
    }

    @JvmStatic
    fun parseBoolean(value: String?): Boolean?
    {
        if (value == null || value.length > 5 || value.length < 4)
        {
            return null
        }
        return when
        {
            value.equals("true", ignoreCase = true) -> true
            value.equals("false", ignoreCase = true) -> false
            else -> null
        }
    }
}
