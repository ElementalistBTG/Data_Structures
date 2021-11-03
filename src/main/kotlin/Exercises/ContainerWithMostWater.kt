package Exercises

//similar to best time to buy stockss
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            maxArea = Math.max(
                maxArea,
                Math.min(height[left], height[right]) * (right - left)
            )
            if (height[left] < height[right])
                left++
            else
                right--
        }
        return maxArea
    }
}//time O(n), space O(1)

fun main() {
    val myClass = ContainerWithMostWater()
    val areas = intArrayOf(5, 1, 1, 5)
    println("max area is: ${myClass.maxArea(areas)}")
}