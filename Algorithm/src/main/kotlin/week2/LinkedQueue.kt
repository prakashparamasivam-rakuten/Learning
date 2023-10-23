package week2

class LinkedQueue<T> {
    var first: Node<T>? = null
    var last: Node<T>? = null

    fun deQueue(): T? {
        val item = first?.item
        first?.let {
            first = first?.next
            if (isEmpty()) last = null
        }
        return item
    }

    fun enQueue(item: T) {
        val oldLast = last
        last = Node<T>()
        last!!.item = item
        last!!.next = null

        if (isEmpty()) {
            first = last
        } else {
            oldLast?.let {
                oldLast.next = last
            }
        }
    }

    fun isEmpty() = first == null

    class Node<T> {
        var item: T? = null
        var next: Node<T>? = null

        override fun toString(): String {
            val s = "Node(item=${item?.toString()} , Next=${next?.toString()} )"
            return s
        }
    }
}