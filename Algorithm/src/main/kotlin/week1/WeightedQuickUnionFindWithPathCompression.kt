package week1

class WeightedQuickUnionFindWithPathCompression(N:Int): WeightedQuickUnionFind(N) {
    protected override fun root(index:Int) : Int{
        var i = index
        while (i != id[i]){
            id[i]= id[id[i]]
            i = id[i]
        }
        return i
    }

}
fun main(args: Array<String>) {
    println("Hello World! WeightedQuickUnionFindWithPathCompression")
    val N:String? = readLine()
    val size = N?.toIntOrNull() ?: 0
    val uf = WeightedQuickUnionFindWithPathCompression(size)
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