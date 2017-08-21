package pl.margoj.server.api.utils

@Suppress("UNCHECKED_CAST")
class ListFromMap<T>(val map: MutableMap<Int, T>, override val size: Int) : AbstractMutableList<T>()
{
    override fun add(index: Int, element: T)
    {
        this.map.put(index, element)
    }

    override fun removeAt(index: Int): T
    {
        return this.map.remove(index) as T
    }

    override fun set(index: Int, element: T): T
    {
        return this.map.put(index, element) as T
    }

    override fun get(index: Int): T
    {
        return this.map[index] as T
    }
}