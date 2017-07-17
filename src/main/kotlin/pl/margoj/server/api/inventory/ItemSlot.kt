package pl.margoj.server.api.inventory

/**
 * Reprezentuje slot przedmiotu
 */
enum class ItemSlot(val margoId: Int)
{
    /**
     * W torbie
     */
    DEFAULT(0),

    /**
     * Torba pierwsza
     */
    BAG1(21),

    /**
     * Torba druga
     */
    BAG2(22),

    /**
     * Torba trzecia
     */
    BAG3(23),

    /**
     * Torba na klucze
     */
    BAG_KEYS(24);
}