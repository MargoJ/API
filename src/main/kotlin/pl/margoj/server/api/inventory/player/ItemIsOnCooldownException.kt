package pl.margoj.server.api.inventory.player

class ItemIsOnCooldownException(val left: Long) : Exception("Item is on cooldown for $left milliseconds")