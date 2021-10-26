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

    //for arrays that are nearly sorted
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

    fun mergeSort() {}

    fun quickSort() {}


}