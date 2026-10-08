// Task 4.5: summing odd integers with a for loop

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    
    if (args.size != 1) {
        println("Usage: ./kotlin run -- <limit>")
        return
    }

    val limit = args[0].toInt()

    var sum = 0L

    for (number in 1..limit step 2) {
        sum += number.toLong()
    }

    println(sum)
}
