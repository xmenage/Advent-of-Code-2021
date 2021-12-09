import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/day2-input.txt").bufferedReader()
    //   val inputString = bufferedReader.use { it.readText() }
    val depthList = bufferedReader.use { it.readLines() }
    var incDepth:Int = 0
    var incForward:Int = 0
    var incAim:Int = 0
    println("list size ${depthList.size}")
    for(command in depthList){
        val commandElements = command.split(" ")
        println(commandElements)
        val f = commandElements[1].toInt()
        if (commandElements[0] == "forward") {
            incForward += f
            incDepth += incAim*f
        }
        else if(commandElements[0] == "down") {
            incAim += f
        }
        else if(commandElements[0] == "up") {
            incAim -= f
        }
        println("$incAim, $incForward, $incDepth, ${incForward*incDepth}")

    }
    println("$incAim, $incForward, $incDepth, ${incForward*incDepth}")

}