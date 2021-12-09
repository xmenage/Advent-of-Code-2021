import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/input.txt").bufferedReader()
    val depthList = bufferedReader.use { it.readLines() }
    println("list size ${depthList.size}")
    val depthListInt = mutableListOf<Int>(depthList.size)
    for(depthSring in depthList)
        depthListInt.add(depthSring.toInt())
    var incDepth:Int = 0
    val windowSize:Int = 3
    var previousDepth = depthListInt.subList(1,windowSize+1).sum()
    println(previousDepth)
 for (i in windowSize+2 .. (depthListInt.size)){
        var nextDepth:Int=depthListInt.subList(i-windowSize,i).sum()
 //    println(nextDepth)
        if(nextDepth > previousDepth) incDepth++
        previousDepth = nextDepth
    }
    println(incDepth)

}