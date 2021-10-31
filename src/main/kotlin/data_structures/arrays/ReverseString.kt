package data_structures.arrays.reverse_string

/**
Exercise: Reverse a string
 */

fun reverse(str: String): String {
    //val strArray = str.map { it.toString() }.toTypedArray()
    val backwards: Array<Char?> = arrayOfNulls<Char>(str.length)
    for (i in str.indices) {
        backwards[i] = str[str.length - 1 - i]
        //backwards[i]= strArray[str.length-1-i]
    }
    return backwards.joinToString("")
}

private fun reverse2(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0) {
        result += string[i]
    }
    return result
}

// Note: This method uses built-in function called reversed()
private fun reverse3(string: String) = string.reversed()

fun main() {
    println(reverse("Hello, World!"))
    println(reverse2("Hello, World!"))
    println(reverse3("Hello, World!"))
}