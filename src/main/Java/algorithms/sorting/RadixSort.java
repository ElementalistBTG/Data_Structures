package algorithms.sorting;

import java.util.*;

// Radix Sort in Java Programming

import java.util.Arrays;

class RadixSort {

    //Best, average and worst case time complexity: nk where k is the maximum number of digits in elements of array.
    public static void sort(int numbers[]) {
        int maximumNumber = findMaximumNumberIn(numbers);

        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

        int placeValue = 1;

        //OR
        //for (int place = 1; max / place > 0; place *= 10){
        //      countingSort(array, place);}
        while (numberOfDigits-- > 0) {
            applyCountingSortOn(numbers, placeValue);
            placeValue *= 10;
        }
    }

    //Counting sort has O(n+k) time complexity where k is the size of count array
    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        //find the frequency of each number
        for (int number : numbers) {
            int digit = (number / placeValue) % range;
            frequency[digit]++;
        }

        //get the sum of frequencies
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    // Driver code
    public static void main(String[] args) {
        int[] data = {121, 432, 564, 23, 1, 45, 788, 2, 32, 22, 152, 77, 27, 777, 555, 5, 95, 99, 999};
        RadixSort rs = new RadixSort();
        rs.sort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
