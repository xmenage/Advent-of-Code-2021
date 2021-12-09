import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/day3-input.txt").bufferedReader()
    //   val inputString = bufferedReader.use { it.readText() }
    val depthList = bufferedReader.use { it.readLines() }
    //var bitCount = Array<Int>(5,{i -> 0})
    var bitCount = arrayOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)

    println(bitCount.toList())
    var incAim:Int = 0
    println("list size ${depthList.size}")
    for(command in depthList){
//        val commandElements = command.toCharArray()
        command.forEachIndexed{index, element -> if(element == '1') bitCount[index]++}
        println(bitCount.toList())
    }
//    println("$incAim, $incForward, $incDepth, ${incForward*incDepth}")
    val halfListSize = depthList.size/2
    println("halfListSize: $halfListSize")
    var mostCommonbitString:String = ""
    bitCount.forEach { i -> if(i>halfListSize) mostCommonbitString += '1' else mostCommonbitString += '0' }
    println("mostCommonbitString: $mostCommonbitString")
    val gammaRate:Int = mostCommonbitString.toInt(2)
    val epsilonRate:Int = 0b111111111111 - gammaRate
    println("gammaRate: $gammaRate, epsilonRate: $epsilonRate, power consumption:${gammaRate*epsilonRate}")
}