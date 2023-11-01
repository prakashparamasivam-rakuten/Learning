package week2

fun main(args: Array<String>) {
    val arrayStack = DynamicArrayQueue<String>()
    while (true) {
        println(" Enter the string for Queue :")
        val string: String? = readLine()
        if (string == null || string.equals("")) break
        string.let {
            if (it.trim().equals("-")) {
                val poppedItem = arrayStack.deQueue()
                println("popped : ${poppedItem.toString()}")
                println("Current Queue : $arrayStack")
            } else {
                arrayStack.enQueue(it)
                println("Current Queue : $arrayStack")
            }
        }
    }
}

class DynamicArrayQueue<T>() {
    private var itemArray: Array<Any?> = Array(1) { null }
    var head: Int = 0
    var tail = 0

    fun enQueue(item: T): Boolean {
        printPointers()
        if (head == 0 && tail >= itemArray.size) resize(2 * itemArray.size)
        if (tail >= 0 && tail < itemArray.size) {
            itemArray[tail++] = item
            if (tail >= itemArray.size && head != 0) reOrderItemPositions(itemArray.size) // you need to re-order your array to its original position.
            printPointers()
            return true
        }
        return false
    }

    fun deQueue(): T? {
        printPointers()
        if (head in 0 until tail) {
            val item = itemArray[head]
            itemArray[head] = null
            head++
            resetPointersIfNeeded()
            // In queue head and tail is the start and end position of valid items
            if ((tail - head) > 0 && (tail - head) == itemArray.size / 4) resize(itemArray.size / 2)
            printPointers()
            return item as T
        }
        return null
    }

    private fun printPointers(extraText: String = "") {
        println("$extraText  Head-> $head || Tail-> $tail ")
    }

    /**
     * head and tail becomes equal when deque operation is done to remove all the item in the queue.
     */
    private fun resetPointersIfNeeded() {
        if (head >= tail) {
            head = 0
            tail = 0
        }
    }

    private fun reOrderItemPositions(size: Int) {
        val tempArr = Array<Any?>(size) { null }
        for (i in tempArr.indices) {
            tempArr[i] = itemArray[head]
            head++

            if (head >= tail) {
                itemArray = tempArr
                head = 0
                tail = i + 1
                return
            }
        }
    }

    override fun toString(): String {
        return itemArray.toList().toString()
    }

    private fun resize(size: Int) {
        reOrderItemPositions(size)
    }

}
