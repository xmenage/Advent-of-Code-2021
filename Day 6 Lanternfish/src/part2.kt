import java.io.File
import kotlin.io.*


fun main() {
    val numListString: String = File("data/day6-input.txt").readText()
    val numList = numListString.split(',').map { it.toInt() }
    var fishes = LongArray(9) { 0 }
    val k = numList.groupingBy { it }.eachCount()
    k.forEach { numCount ->
        fishes[numCount.key] = numCount.value.toLong()
    }
    println(k)
    println(fishes.toList())
    repeat(256) {
        val f0 = fishes[0]
        for (i in 0..7) {
            fishes[i] = fishes[i + 1]
        }
        fishes[6] += f0
        fishes[8] = f0
    }
    println(fishes.sum())
}