class FirstRecurringValueClass {
    /**Given an array find the first recurring value*/
//Test case
/*
    val myArray = arrayOf(1,2,3,4,1,4)
    val myArray = arrayOf("a","b","c","b")
    println(duplicate(myArray))
 */
    fun <T> duplicate(array : Array<T>): T? {
        val hashSet : MutableSet<T> = mutableSetOf<T>()
        for(element in array){
            if(!hashSet.contains(element))
                hashSet.add(element)
            else
                return element
        }
        return null
    }

}