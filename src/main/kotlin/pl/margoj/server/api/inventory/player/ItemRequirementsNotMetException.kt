package pl.margoj.server.api.inventory.player

class ItemRequirementsNotMetException(val level: Boolean, val profession: Boolean) : Exception("Item requirements not met (level=$level, profession=$profession)")