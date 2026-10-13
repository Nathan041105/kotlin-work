// Task 8.3: weather station temperature analysis program

import kotlin.system.exitProcess

fun main(args: Array<String>) {

    if (args.size != 1) {
        println("Error: Please provide a CSV filename.")
        exitProcess(1)
    }

    val data = fetchData(args[0])

    val coldest = data.minBy { it.second }

    val warmest = data.maxBy { it.second }

    println("Coldest station: ${coldest.first}, ${coldest.second}")

    println("Warmest station: ${warmest.first}, ${warmest.second}")

    val average = data.map { it.second }.average()

    println("Average temperature: %.2f".format(average))
}
