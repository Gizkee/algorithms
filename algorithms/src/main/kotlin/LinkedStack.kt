class LinkedStack : CustomStack<String> {

    private var first: Node? = null

    override val isEmpty: Boolean
        get() = first == null

    override val size: Int
        get() {
            if (isEmpty) return 0

            var count = 0
            var current = first
            while (current != null) {
                count++
                current = current.next
            }
            return count
        }

    override fun push(value: String) {
        first = Node(value, first)
    }

    override fun pop(): String? {
        val result = first?.value
        first = first?.next
        return result
    }

    private class Node(
        var value: String,
        var next: Node? = null
    )
}
