package week2

fun main(args: Array<String>) {
    val arrayStack = FixedArrayCapacityQueue<String>(10)
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

class FixedArrayCapacityQueue<T>(private val capacity:Int) {
    private var itemArray: Array<Any?>? = null
    var head :Int = 0
    var tail = 0
    init {
        itemArray = Array(capacity){null}
    }

    fun enQueue(item: T): Boolean {
        itemArray?.let {
            if (tail >= 0 && tail < it.size) {
                itemArray?.set(tail++, item)
                if(tail >= it.size && head!=0) reOrderItemPositions()
                return true
            }
        }
        return false
    }

    fun deQueue():T?{
        itemArray?.let {
            if (head >= 0 && head < it.size) {
                val item = itemArray?.get(head)
                itemArray?.set(head,null)
                head++
                resetPointersIfNeeded()
                return item as T
            }
        }
        return  null
    }

    private fun resetPointersIfNeeded(){
        if(head >= tail){
            head = 0
            tail = 0
        }
    }
    private fun reOrderItemPositions(){
        val tempArr = Array<Any?>(capacity){null}
        for(i in 0 until tempArr.size){
            tempArr[i] = itemArray?.get(head)
            head++
            if(head >= (itemArray?.size ?: capacity)){
                itemArray = tempArr
                head =0
                tail = i+1
                return
            }
        }
    }

    override fun toString(): String {
        return itemArray?.toList().toString()
    }

//    fun resize(size:Int){
//        var newArray = Array(size){
//            itemArray?.get(it)
//        }
//        itemArray = newArray
//    }

}
