package pl.margoj.server.api.map

/**
 * Reprezentuje lokacje w grze
 */
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

        val xDifference = Math.abs(location.x - this.x)
        val yDifference = Math.abs(location.y - this.y)

        if (diagonals && xDifference == 1 && yDifference == 1)
        {
            return true
        }

        return (xDifference == 1 && yDifference == 0) || (xDifference == 0 && yDifference == 1)
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

    /**
     * Zwraca dokładną odległość pomiędzy aktualną lokacją z podaną lokacją podniesioną do kwadratu
     * Funkcja ta powinna być używana tylko wtedy gry potrzebna jest dokładna lokacja.
     * Do porównań należy używać szybszek funkcji [distanceSquared]
     *
     * @param location lokacja do której odległość ma być zmierzona
     *
     * @return dokładna odległość
     */
    fun distance(location: Location): Int
    {
        return Math.sqrt(this.distanceSquared(location).toDouble()).toInt()
    }

    /**
     * Zwraca odległość pomiędzy aktualną lokacją z podaną lokacją podniesioną do kwadratu
     * Funkcja ta jest znacznie szybsza od [distance] i powinna byc używana jeżeli dokładna wartość nie musi być znana.

     * @param location lokacja do której odległość ma być zmierzona
     *
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
        if (other !is Location) return false

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


    fun toSimpleString(): String
    {
        return """${if (town != null) ("${town!!.id}[${town!!.name}]") else "NULL"}, x = $x, y = $y"""
    }
}