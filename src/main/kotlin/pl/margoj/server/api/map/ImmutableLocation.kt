package pl.margoj.server.api.map

/**
 * [Location] której wartośći są stałe
 */
class ImmutableLocation(town: Town?, x: Int, y: Int) : Location(town, x, y)
{
    override var town: Town?
        get() = super.town
        set(value)
        {
            throw UnsupportedOperationException("immutable")
        }

    override var x: Int
        get() = super.x
        set(value)
        {
            throw UnsupportedOperationException("immutable")
        }

    override var y: Int
        get() = super.y
        set(value)
        {
            throw UnsupportedOperationException("immutable")
        }
}