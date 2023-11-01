package week2

fun main(args: Array<String>) {
    val arrayStack = FixedArrayCapacityStack<String>(10)
    while (true) {
        println(" Enter the string for stack :")
        val string: String? = readLine()
        if (string == null || string.equals("")) break
        string.let {
            if (it.trim().equals("-")) {
                val poppedItem = arrayStack.pop()
                println("popped : ${poppedItem.toString()}")
                println("Current Stack : $arrayStack")
            } else {
                arrayStack.push(it)
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class FixedArrayCapacityStack<T>(val capacity: Int) {
    private var itemArray: Array<Any?>? = null

    private var N: Int = 0;

    init {
        itemArray = Array(size = capacity) { null }
    }

    fun isEmpty() = N == 0

    fun push(item: T?) {
        item?.let {
            itemArray?.set(N++, item)
        }
    }

    fun pop(): T? {
        if (N <= 0 || N >= capacity) return null
        val item = itemArray?.get(--N)
        itemArray?.set(N, null)
        return item as T
    }
    override fun toString(): String {
        return itemArray?.toList().toString()
    }
}