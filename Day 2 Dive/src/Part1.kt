import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/day2-input.txt").bufferedReader()
    //   val inputString = bufferedReader.use { it.readText() }
    val depthList = bufferedReader.use { it.readLines() }
    var incDepth:Int = 0
    var incForward:Int = 0
    println("list size ${depthList.size}")
    for(command in depthList){
        val commandElements = command.split(" ")
        if (commandElements[0] == "forward") incForward += commandElements[1].toInt()
        else if(commandElements[0] == "down") incDepth += commandElements[1].toInt()
        else if(commandElements[0] == "up") incDepth -= commandElements[1].toInt()
    }
    println("$incForward, $incDepth, ${incForward*incDepth}")

}