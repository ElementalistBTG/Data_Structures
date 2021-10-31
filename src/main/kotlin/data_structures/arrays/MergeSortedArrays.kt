package data_structures.arrays

class MergeSortedArrays {

    fun mergeSortedArrays(array1: Array<Int?>, array2: Array<Int?>): Array<Int?> {
        //Check input
        //if one array is empty
        if (array1.isEmpty()) {
            return array2
        }
        if (array2.isEmpty()) {
            return array1
        }

        //check for null elements (since we use Array<Int?>)

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

    fun mergeSortedArrays2(arr1: IntArray, arr2: IntArray): IntArray {
        var i = 0
        var j = 0
        var k = 0

        val mergedArray = IntArray(arr1.size + arr2.size)

        while (i < arr1.size && j < arr2.size) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i]
                i++
            } else {
                mergedArray[k] = arr2[j]
                j++
            }
            k++
        }

        while (i < arr1.size) {
            mergedArray[k] = arr1[i]
            i++
            k++
        }

        while (j < arr2.size) {
            mergedArray[k] = arr2[j]
            j++
            k++
        }

        return mergedArray
    }

    fun main() {
        val mergedArray = mergeSortedArrays2(intArrayOf(0, 2, 3, 56), intArrayOf(0, 6, 7))
        println(mergedArray.contentToString())
    }
}