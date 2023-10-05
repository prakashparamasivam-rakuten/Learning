package week1

class UnionFind(N:Int) {
    val id:IntArray = IntArray(N)

    init {
        for(i in 0 until N){
            id[i] = i
        }
    }
    fun union(p:Int,q:Int){
        val pId = id[p]
        val qId = id[q]
        for(i in 0 until id.size){
            if(id[i] == pId) id[i]= qId
        }
    }
    fun connected(p:Int,q:Int) : Boolean = id[p] == id[q]

}
fun main(args: Array<String>) {
    println("Hello World! UnionFind")
    val N:String? = readLine()
    val size = N?.toIntOrNull() ?: 0
    val uf = UnionFind(size)
    while (true){
        val input = readLine()
        if(input == null || input.isEmpty()) break

        val inputToken = input.split(" ")
        val p = inputToken[0].toInt()
        val q = inputToken[1].toInt()
        if(uf.connected(p,q).not()){
            uf.union(p,q)
            println("$p $q")
        }
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()} and Input:$N")
}