package week1

open class QuickUnionFind(N:Int) {
    val id:IntArray = IntArray(N)

    init {
        for(i in 0 until N){
            id[i] = i
        }
    }
    protected open fun root(index:Int) : Int{
        var i = index
        while (i != id[i]) i = id[i]
        return i
    }
    fun union(p:Int,q:Int){
        val i = root(p)
        val j = root(q)
        id[i] = j
    }
    fun connected(p:Int,q:Int) : Boolean = root(p) == root(q)

    fun print() {
        var printArrInd = IntArray(id.size)
        for(i in 0 until id.size) printArrInd[i] = i

        println(printArrInd.toList().toString())
        println(id.toList().toString())
    }
}
fun main(args: Array<String>) {
    println("Hello World! QuickUnionFind")
    val N:String? = readLine()
    val size = N?.toIntOrNull() ?: 0
    val uf = QuickUnionFind(size)
    while (true){
        val input = readLine()
        if(input == null || input.isEmpty()) break

        val inputToken = input.split(" ")
        val p = inputToken[0].toInt()
        val q = inputToken[1].toInt()
        if(uf.connected(p,q).not()){
            uf.union(p,q)
            println("\n $p $q")
            uf.print()
        }
    }


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()} and Input:$N")
}