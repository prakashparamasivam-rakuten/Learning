package week2

fun main(args: Array<String>) {
    val arrayStack = DynamicArrayStack<String>(10)
    while (true) {
        println(" Enter the string for stack :")
        val string: String? = readLine()
        if (string == null || string.equals("")) break
        string.let {
            if (it.trim().equals("-")) {
                val poppedItem = arrayStack.pop()
                println("popped : ${poppedItem.toString()}")
            } else {
                arrayStack.push(it)
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class DynamicArrayStack<T>(val capacity: Int) {
    private var itemArray: Array<Any?> = Array(size = 1) { null }

    private var N: Int = 0;
    fun isEmpty() = N == 0

    fun push(item: T?) {
        if (N == itemArray.size) resize(2 * itemArray.size)
        item?.let {
            itemArray.set(N++, item)
        }
    }

    fun pop(): T? {
        if (N <= 0 || N >= capacity) return null
        val item = itemArray.get(--N)
        itemArray.set(N, null)
        if (N > 0 && N == itemArray.size / 4) resize(itemArray.size / 2)
        return item as T
    }

    private fun resize(capacity: Int) {
        val newArray: Array<Any?> = Array(size = capacity) { null }
        for (i in 0 until N) {
            newArray[i] = itemArray[i]
        }
        itemArray = newArray
        println("New stack size : ${itemArray.size}")
    }
}