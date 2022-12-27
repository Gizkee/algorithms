interface CustomStack<T> {

    val isEmpty: Boolean

    val size: Int

    fun push(value: T)

    fun pop(): T?
}
