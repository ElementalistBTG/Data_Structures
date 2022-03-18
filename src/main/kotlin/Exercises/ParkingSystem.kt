package Exercises

/**
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the ParkingSystem class:

ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.
 */


class ParkingSystem(big: Int, medium: Int, small: Int) {

    var bigSpaces = big
    var mediumSpaces = medium
    var smallSpaces = small

    fun addCar(carType: Int): Boolean {
        when (carType) {
            1 -> if (bigSpaces > 0) {
                bigSpaces--
                return true
            }
            2 -> if (mediumSpaces > 0) {
                mediumSpaces--
                return true
            }
            3 -> if (smallSpaces > 0) {
                smallSpaces--
                return true
            }
        }
        return false
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */