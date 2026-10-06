// Task 4.2: use of if and ranges

fun main() {
    println("PIZZA MENU")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")

    print("Choose your pizza (a-d): ")

    val choice = readln().lowercase()

    val message = if (choice.length == 1 && choice[0] in 'a'..'d') {
        "Order accepted"
    } else {
        "Invalid choice!"
    }

    println(message)
}