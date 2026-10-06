// Task 4.3: grade calculation using a when expression

import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Error: please provide exactly three marks.")
        exitProcess(1)
    }

    val mark1 = args[0].toInt()
    val mark2 = args[1].toInt()
    val mark3 = args[2].toInt()

    val average = (mark1 + mark2 + mark3) / 3.0
    val roundedAverage = average.roundToInt()

    val grade = when (roundedAverage) {
        in 0..39 -> "Fail"
        in 40..69 -> "Pass"
        in 70..100 -> "Distinction"
        else -> "?"
    }

    println("Average mark: $roundedAverage")
    println("Grade: $grade")
}