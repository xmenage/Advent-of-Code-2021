import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/input.txt").bufferedReader()
 //   val inputString = bufferedReader.use { it.readText() }
    val depthList = bufferedReader.use { it.readLines() }
    var incDepth:Int = 0;
    println("list size ${depthList.size}")
    var DepthIterator = depthList.iterator()
    var previousDepth = DepthIterator.next().toInt()
    while (DepthIterator.hasNext()){
        var nextDepth:Int=0
        var nextString = DepthIterator.next()
        if(nextString.isNotEmpty()){
            nextDepth = nextString.toInt()
        }
        if(nextDepth > previousDepth) incDepth++
        previousDepth = nextDepth
    }
    println(incDepth)

}