package pl.margoj.server.api.sync

interface Waitable<out ResultT>
{
    val isDone: Boolean

    val result: ResultT?

    fun wait(): ResultT?
}