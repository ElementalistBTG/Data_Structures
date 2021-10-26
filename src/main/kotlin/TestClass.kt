fun main() {

    val myNumberArray = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    val sortingClass = algorithms.SortingAlgorithms()
    val sortedArray = sortingClass.insertionSort(myNumberArray)
    for (i in sortedArray) {
        print(" $i")
    }

}

