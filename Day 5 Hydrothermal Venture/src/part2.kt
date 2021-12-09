import java.io.File
import java.io.BufferedReader

fun main() {
    val bufferedReader: BufferedReader = File("data/day5-input.txt").bufferedReader()
    var boardList = mutableListOf<List<String>>()
    bufferedReader.forEachLine { ligne ->
        if (ligne.length > 0) {
            boardList.add(ligne.trim().split(" -> ".toRegex()))
        }
    }
    var grid = Array(1000) { IntArray(1000) { 0 } }
    boardList.forEach {
        var (a, b) = it[0].split(',').map { it.toInt() }
        var (c, d) = it[1].split(',').map { it.toInt() }
        if (a == c || b == d){
            if (a > c) {
                val h = a; a = c; c = h
            }
            if (b > d) {
                val h = b; b = d; d = h
            }

            for (i in a..c)
                for (j in b..d) {
                    grid[i][j]++
                }
        }
        else
        {
            var step0:Int = 1
            if (a > c) {
                step0 = -1
            }
            var countStep =(c-a)*step0
            var step1:Int = 1
            if (b > d) {
                step1 = -1
            }

            for (i in 0..countStep)
                grid[a+i*step0][b+i*step1]++
        }

    }
    var total: Int = 0
    for (i in 0..999) for (j in 0..999)
        if (grid[i][j] >= 2) total++
    println("total $total")
}