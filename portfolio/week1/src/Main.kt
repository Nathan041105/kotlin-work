// COMP2850 Portfolio: Week 1
// Program to compute area of a triangle

import kotlin.math.sqrt
import kotlin.system.exitProcess
import java.util.Locale

fun main(args: Array<String>) {

    if (args.size < 3) {
        println("Error: values for a, b, c required on command line")
        exitProcess(1)
    }

    val a = args[0].toDouble()
    val b = args[1].toDouble()
    val c = args[2].toDouble()

    val s = (a + b + c) / 2.0

    val area = sqrt(s * (s - a) * (s - b) * (s - c))

    println(String.format(Locale.US, "Area = %.5f", area))
}