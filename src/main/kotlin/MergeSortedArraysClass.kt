class MergeSortedArraysClass {

    fun mergeSortedArrays(array1: Array<Int?>, array2: Array<Int?>): Array<Int?> {

        /**check input */

        //if one array is empty
        if (array1.isEmpty()) {
            return array2
        }
        if (array2.isEmpty()) {
            return array1
        }

        //check for null elements

        //return array
        val returnArray = arrayOfNulls<Int?>(array1.size + array2.size)
        //index of arrays
        var indexOfArray1 = 0
        var indexOfArray2 = 0
        var indexOfReturnArray = 0
        while (indexOfArray1 < array1.size || indexOfArray2 < array2.size) {
            if (indexOfArray1 == array1.size) {
                returnArray[indexOfReturnArray] = array2[indexOfArray2]
                indexOfArray2++
            } else if (indexOfArray2 == array2.size) {
                returnArray[indexOfReturnArray] = array1[indexOfArray1]
                indexOfArray1++
            } else {
                if (array1[indexOfArray1]!! < array2[indexOfArray2]!!) {
                    returnArray[indexOfReturnArray] = array1[indexOfArray1]
                    indexOfArray1++
                } else {
                    returnArray[indexOfReturnArray] = array2[indexOfArray2]
                    indexOfArray2++
                }
            }
            indexOfReturnArray++
        }
        return returnArray
    }//O(a+b) time complexity
}