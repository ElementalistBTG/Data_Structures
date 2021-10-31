package data_structures.hash_tables

class FirstRecurringValue {
    /**Given an array find the first recurring value*/

    fun <T> firstRecurringValue(array: Array<T>): T? {
        val hashSet: MutableSet<T> = mutableSetOf<T>()
        for (element in array) {
            if (!hashSet.contains(element))
                hashSet.add(element)
            else
                return element
        }
        return null
    }

    fun main() {
        val myArray = arrayOf(1,2,3,4,1,4)
        val myArray2 = arrayOf("a","b","c","b")
        println(firstRecurringValue(myArray))

    }
}