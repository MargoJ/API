package pl.margoj.server.api.utils

import java.util.Collections

/**
 * Prosta klasa pomagajaca wyswietlac listy uzywajac strona
 */
abstract class Paged<T>
{
    /**
     * Ilosc elementow
     */
    abstract val size: Int

    /**
     * Ile elementow wyswietlac na strone
     */
    abstract val entriesPerPage: Int

    /**
     * Maksymalna strona
     */
    val maxPage: Int get() = Math.ceil(this.size.toDouble() / this.entriesPerPage.toDouble()).toInt()

    /**
     * Zwraca element znajdujący się na danej pozycji
     */
    abstract fun getAt(id: Int): T

    /**
     * Pobiera zakres indeksow dla danej strony
     */
    fun getRangeForPage(page: Int): IntRange
    {
        return ((page - 1) * entriesPerPage) until (page * entriesPerPage)
    }

    /**
     * Sprawdza czy podana strona istnieje
     */
    fun isThereAPage(page: Int): Boolean
    {
        return page in 1..maxPage
    }

    /**
     * Sprawdza czy po podanej stronie jest nastepna
     */
    fun isThereANextPage(page: Int): Boolean
    {
        return page < maxPage
    }

    /**
     * Pobiera elementy dla danej strony
     */
    fun getValuesForPage(page: Int): List<T>
    {
        val indexRange = 0 until this.size
        val pageRange = this.getRangeForPage(page)

        if (pageRange.first !in indexRange)
        {
            return Collections.emptyList()
        }

        val output = ArrayList<T>(this.entriesPerPage)

        for (i in pageRange)
        {
            if (i !in indexRange)
            {
                break
            }

            output.add(this.getAt(i))
        }

        return output
    }

    companion object
    {
        private class ListBasedPaged<T>(val list: List<T>, override val entriesPerPage: Int) : Paged<T>()
        {
            override val size: Int
                get() = this.list.size

            override fun getAt(id: Int): T
            {
                return this.list[id]
            }
        }

        /**
         * Tworzy nowy [Paged] bazujący na liście
         */
        @JvmStatic
        fun <T> createListBasedPaged(list: List<T>, entriesPerPage: Int): Paged<T>
        {
            return ListBasedPaged<T>(list, entriesPerPage)
        }
    }
}