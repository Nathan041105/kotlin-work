// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact(
    document: String,
    target: String,
    replacement: Char = 'X'
): String {

    if (target.isEmpty()) {
        return document
    }

    val replacementText = replacement.toString().repeat(target.length)

    return document.replace(target, replacementText)
}