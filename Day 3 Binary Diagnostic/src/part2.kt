import java.io.File
import java.io.BufferedReader

fun main(){
    val bufferedReader: BufferedReader = File("data/day3-input.txt").bufferedReader()
     val depthList = bufferedReader.use { it.readLines() }
    println("list size ${depthList.size}")
    var listSource = depthList
    println("longueur de la chaîne: ${depthList.first().length}")
    for(i in 0 until depthList.first().length) {
        var list1 = mutableListOf<String>()
        var list0 = mutableListOf<String>()
        for (command in listSource) {
            if(command.toCharArray()[i] == '1')
                list1.add(command)
            else
                list0.add(command)
        }
        if (list1.size >= list0.size) listSource = list1 else listSource = list0
        if (listSource.size == 1) break
    }
    println(listSource)
    val oxygenGeneratorRating = listSource.first().toInt(2)

    listSource = depthList
    for(i in 0 until depthList.first().length) {
        var list1 = mutableListOf<String>()
        var list0 = mutableListOf<String>()
        for (command in listSource) {
            if(command.toCharArray()[i] == '1')
                list1.add(command)
            else
                list0.add(command)
        }
        if (list1.size < list0.size) listSource = list1 else listSource = list0
        if (listSource.size == 1) break
    }
    println(listSource)
    val CO2ScrubberRating = listSource.first().toInt(2)
    println("oxygenGeneratorRating: $oxygenGeneratorRating, CO2ScrubberRating: $CO2ScrubberRating, life support rating: ${oxygenGeneratorRating*CO2ScrubberRating}")
}