package algorithms

class SortingAlgorithms {
    fun customSort(array: Array<Int>): Array<Int> {
        val arraySize = array.size
        for (i in 0..arraySize - 2) {
            for (j in i + 1 until arraySize) {
                if (array[i] > array[j]) {
                    val temp = array[j]
                    array[j] = array[i]
                    array[i] = temp
                }
            }
        }
        return array
    }
    //never used
    fun bubbleSort(array: Array<Int>): Array<Int> {
        val arraySize = array.size
        for (i in 0 until arraySize - 1) {
            for (j in 0 until arraySize - 1) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
        return array
    }
    //never used
    fun selectionSort(array: Array<Int>): Array<Int> {
        val arraySize = array.size
        for (i in 0 until arraySize) {
            var min = i
            var temp = array[i]
            for (j in i + 1 until arraySize) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            array[i] = array[min]
            array[min] = temp
        }
        return array
    }
    //for arrays that are nearly sorted, easiest code implementation
    fun insertionSort(array: Array<Int>): Array<Int> {

        val arraySize = array.size
        if (array.isEmpty() || arraySize < 2) {
            return array
        }

        for (count in 0 until arraySize) {
            val item = array[count]
            var i = count
            while (i > 0 && item < array[i - 1]) {
                array[i] = array[i - 1]
                i -= 1
            }
            array[i] = item
        }
        return array
    }
    //list implementation
    fun insertionSort(items: MutableList<Int>): List<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }
        for (count in 1 until items.count()) {
            // println(items)
            val item = items[count]
            var i = count
            while (i > 0 && item < items[i - 1]) {
                items[i] = items[i - 1]
                i -= 1
            }
            items[i] = item
        }
        return items
    }
    //time complexity: O(nlog(n)) and space complexity O(n). Best algorithm for worst case scenarios
    fun mergeSort(array: Array<Int>): Array<Int> {
        if (array.size == 1) {
            return array
        }
        //Split array in right and left
//        val leftArray: Array<Int> = array.take(array.size/2).toIntArray().toTypedArray()
//        val rightArray = array.takeLast(array.size/2).toIntArray().toTypedArray()
        val middleValue = array.size / 2
        val leftArray = array.slice(0 until middleValue).toTypedArray()
        val rightArray = array.slice(middleValue until array.size).toTypedArray()
        return merge(
            mergeSort(leftArray),
            mergeSort(rightArray)
        )
    }

    private fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
        //combine left and right
        val combinedArray = IntArray(left.size + right.size)
        var leftCounter = 0
        var rightCounter = 0
        var combinedCounter = 0
        while (true) {
            if (left[leftCounter] > right[rightCounter]) {
                combinedArray[combinedCounter] = right[rightCounter]
                rightCounter++
                combinedCounter++
            } else {
                combinedArray[combinedCounter] = left[leftCounter]
                leftCounter++
                combinedCounter++
            }
            if (rightCounter >= right.size || leftCounter >= left.size) {
                break
            }
        }
        if (rightCounter >= right.size) {
            for (i in leftCounter until left.size) {
                combinedArray[combinedCounter] = left[i]
                combinedCounter++
            }
        } else {
            for (i in rightCounter until right.size) {
                combinedArray[combinedCounter] = right[i]
                combinedCounter++
            }
        }
        return combinedArray.toTypedArray()
    }

    //Select first and last index as 2nd and 3rd parameters
    //    val sortingClass = algorithms.SortingAlgorithms()
    //    val sortedArray = sortingClass.quickSort(myNumberArray,0,myNumberArray.size-1)
    //time complexity: O(nlog(n)) on average and O(n^2) worst case. and space complexity O(log(n))
    fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pIndex = partition(arr, low, high)
            quickSort(arr, low, pIndex - 1)
            quickSort(arr, pIndex + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++

                // swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }


}
//interview questions about which algorithm to pick
//#1 - Sort 10 schools around your house by distance: insertion sort

//#2 - eBay sorts listings by the current Bid amount: radix or counting sort (numbers within a certain range)

//#3 - Sport scores on ESPN: quick sort (we need better space complexity probably)

//#4 - Massive database (can't fit all into memory) needs to sort through past year's user data: merge sort (since we need the better performance of merge sort)

//#5 - Almost sorted Udemy review data needs to update and add 2 new reviews: insertion sort

//#6 - Temperature Records for the past 50 years in Canada: radix or counting sort (if we don't have float data) else quicksort

//#7 - Large user name database needs to be sorted. Data is very random.: merge sort(if we have enough memory) or quicksort

//#8 - You want to teach sorting for the first time: bubble sort, selection sort
