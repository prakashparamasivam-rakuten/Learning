package week1

open class WeightedQuickUnionFind(N:Int) {
    val id:IntArray = IntArray(N)
    val sz:IntArray = IntArray(N)

    init {
        for(i in 0 until N){
            id[i] = i
            sz[i] = 1
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
        if(i == j) return
        if(sz[i]<sz[j]){
            id[i] = j
            sz[j] += sz[i]
        }else {
            id[j] = i
            sz[i] += sz[j]
        }

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
    println("Hello World! WeightedQuickUnionFind")
    val N:String? = readLine()
    val size = N?.toIntOrNull() ?: 0
    val uf = WeightedQuickUnionFind(size)
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