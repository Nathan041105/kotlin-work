// Task 4.7: finding the longest line in a file

import kotlin.io.path.Path
import kotlin.io.path.forEachLine

fun main(args: Array<String>) {

    if (args.size != 1) {
        println("Usage: ./kotlin run -- <file-path>")
        return
    }

    val filePath = Path(args[0])

    var currentLineNumber = 0
    var longestLineNumber = 0
    var longestLength = -1

    filePath.forEachLine { line ->

        currentLineNumber++

        val length = line.length

        if (length > longestLength) {
            longestLength = length
            longestLineNumber = currentLineNumber
        }
    }

    if (longestLineNumber == 0) {
        println("The file is empty")
    } else {
        println("Line $longestLineNumber is the longest (length = $longestLength)")
    }
}