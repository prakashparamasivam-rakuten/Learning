package week2

fun main(args: Array<String>) {
    val linkedStack = LinkedStack<String>()
    while (true) {
        println(" Enter the string for stack :")
        val string: String? = readLine()
        if(string == null || string.equals("")) break
        string.let {
            if (it.trim().equals("-")) {
                val poppedItem = linkedStack.pop()
                println("popped : ${poppedItem.toString()}")
            } else {
                linkedStack.push(it)
            }
        }
    }
}
class LinkedStack<T>() {
    private var first :Node<T>? = null

    fun push(item:T){
        val oldFirst = first
        first = Node()

        first?.let {
            first!!.item = item
            first!!.next = oldFirst
        }
        println("stack after push : ${first.toString()}")
    }
    fun pop():T?{
        val item:T? = first?.item
        first = first?.next
        println("stack after pop : ${first.toString()}")
        return item
    }
    fun isEmpty() =  first?.item == null

    fun size(){

    }

    class Node<T>{
        var item:T? = null
        var next:Node<T>? = null

        override fun toString(): String {
            val s = "Node(item=${item?.toString()} , Next=${next?.toString()} )"
            return s
        }
    }
}
