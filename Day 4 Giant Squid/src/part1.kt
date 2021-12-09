import java.io.File
import java.io.BufferedReader

fun main() {
    val bufferedReader: BufferedReader = File("data/day4-input.txt").bufferedReader()
    val bingoNumberList = bufferedReader.readLine().split(",").map { it.toInt() }
    println(bingoNumberList)
    println(bingoNumberList.sum())
    var boardList = mutableListOf<List<Int>>()
    bufferedReader.forEachLine { ligne ->
        if (ligne.length > 0) {
            boardList.add(ligne.trim().split(" +".toRegex()).map { it.toInt() })
        }
    }

    val nboard = boardList.size.floorDiv(5)
    var boardLineSum = IntArray(boardList.size) { 0 }
    var boardColSum = arrayOf<IntArray>()
    for (i in 1..nboard) {
        boardColSum += IntArray(5) { 0 }
    }
    var boardRemainSum = IntArray(nboard) { 0 }
    boardList.forEachIndexed { li, bingoline ->
        val boardnum = li.floorDiv(5)
        boardRemainSum[boardnum] += bingoline.sum()
    }
    var lastdrawnnum: Int = 0
    var bingoremainsum: Int = 0
    var finished = false
    var numberIt = bingoNumberList.iterator()
    while (!finished && numberIt.hasNext()) {
        val nb = numberIt.next() //tirer le prochain nombre
        boardList.forEachIndexed { li, bingoline -> //parcourir l'ensemble des lignes
            val boardnum = li.floorDiv(5) //calculer le numero du board sur lequel se trouve la ligne
            if (nb in bingoline) { //si le nombre se trouve sur la ligne alors mettre à jour les tableaux de suivi
                val col = bingoline.indexOf(nb)
                boardColSum[boardnum][col]++
                boardLineSum[li]++
                boardRemainSum[boardnum] -= nb
            }

            // test si bingo sur la ligne ou la colonne
            if (boardLineSum[li] == 5 || 5 in boardColSum[boardnum]) { //si tous les nombres d'une même ligne ou d'une même colonne ont été tirés
                finished = true
                bingoremainsum = boardRemainSum[boardnum]
                lastdrawnnum = nb
            }

        }
    }
    println("lastdrawnnum $lastdrawnnum, bingoremainsum $bingoremainsum, ${lastdrawnnum * bingoremainsum}")

}