package week1.practice

import week1.UnionFind

class FindLargestInUnionFind(private val N:Int):UnionFind(N) {
    fun find(index:Int):Int{
        var i = 0
        val value = id[index]
        var largest = index
        while (i < id.size){
            if(id[i] == value && id[i] > largest) largest = id[i]
            i = i+1
        }
        return largest
    }
}
fun main(args: Array<String>) {
    println("Hello World! FindLargestInUnionFind")
    println("Please enter Array Size :")
    val N:String? = readLine()
    val size = N?.toIntOrNull() ?: 0
    val uf = FindLargestInUnionFind(size)
    while (true){
        println("Please choose your operation (1)-> Union , (2)->Find largest number")
        val input = readLine()
        if(input == null || input.replace(" ","").isEmpty()) break
        when(input.toInt()){
            1 -> {
                println("Input 2 index within the array size with a space (eg)'3 4' :")
                val inputForUnion = readLine()
                if(inputForUnion == null || inputForUnion.replace(" ","").isEmpty()) {
                    println("provided input is not proper,please enter valid entry")
                    continue
                }
                val inputToken = inputForUnion.split(" ")
                val p = inputToken[0].toInt()
                val q = inputToken[1].toInt()
                if(uf.connected(p,q).not()){
                    uf.union(p,q)
                    println("$p $q")
                    uf.print()
                }
            }
            2-> {
                println("Input an index to find its largest element in the connected component : ")
                uf.print()
                val inputForFindOperation = readLine()
                if(inputForFindOperation == null || inputForFindOperation.replace(" ","").isEmpty()) {
                    println("provided input is not proper,please enter valid entry")
                    continue
                }
                val largest = uf.find(inputForFindOperation.toInt())
                println("Largest in the component is : $largest")

            }
            else -> Unit
        }
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()} and Input:$N")
}