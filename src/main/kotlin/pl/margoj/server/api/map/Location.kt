package pl.margoj.server.api.map

open class Location(
        /**
         * Mapa aktualnej kolacji
         */
        open var town: Town?,

        /**
         * Koordynat X lokacji
         */

        open var x: Int = 0,

        /**
         * Koordynat Y lokacji
         */
        open var y: Int = 0)
{

    /**
     * Zwraca czy dana lokacja znajduje się obok aktualnej lokacji.
     *
     * @param location  lokacja do sprawdzenia
     * @param diagonals czy uwzględnic przekątne?
     *
     * @return czy lokacja jest obok
     */
    fun isNear(location: Location, diagonals: Boolean = false): Boolean
    {
        if (this.town != location.town)
        {
            return false
        }

        if (this == location)
        {
            return true
        }

        val xDiffers = Math.abs(location.x - this.x) == 1
        val yDiffers = Math.abs(location.y - this.y) == 1

        return if (diagonals) (xDiffers || yDiffers) else ((xDiffers && !yDiffers) || (yDiffers && !xDiffers))
    }

    /**
     * Kompiuje lokacje, tworzy nowy obiekt z takimi samymi wartosciami

     * @return kopia lokacji
     */
    fun copy(): Location
    {
        return Location(this.town, this.x, this.y)
    }


    /**
     * Kompiuje lokacje, tworzy nowy obiekt z takimi samymi wartosciami.
     * Stworzony obiekt jest staly i nie moze byc edytowany

     * @return kopia lokacji
     */
    fun copyImmutable(): ImmutableLocation
    {
        return ImmutableLocation(this.town, this.x, this.y)
    }

    /**
     * Kopiuje aktualne wartości lokacji do podanej lokacji

     * @param location lokacja do której wartośći mają być skopiowane
     */
    fun copyValuesTo(location: Location)
    {
        location.town = this.town
        location.x = this.x
        location.y = this.y
    }

    fun distance(location: Location): Int
    {
        return Math.sqrt(this.distanceSquared(location).toDouble()).toInt()
    }

    /**
     * Zwraca odległość pomiędzy aktualną lokacją z podaną lokacją podniesioną do kwadratu
     * Funkcja ta jest znacznie szybsza od [.distance] i powinna byc używana jeżeli dokładna wartość nie musi być znana.

     * @param location lokacja do której odległość ma być zmierzona
     * *
     * *
     * @return odległość podniesiona do kwadratu
     */
    fun distanceSquared(location: Location): Int
    {
        val p1 = this.x - location.x
        val p2 = this.y - location.y
        return p1 * p1 + p2 * p2
    }

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Location

        if (town != other.town) return false
        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int
    {
        var result = town?.hashCode() ?: 0
        result = 31 * result + x
        result = 31 * result + y
        return result
    }

    override fun toString(): String
    {
        return "Location(town=$town, x=$x, y=$y)"
    }
}