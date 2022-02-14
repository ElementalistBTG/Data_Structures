package Exercises

/**

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

 */

class MyHashSet() {
    private val keys = mutableListOf<Int>()

    fun add(key: Int) {
        if(!keys.contains(key)) keys.add(key)
    }

    fun remove(key: Int) {
        if(keys.contains(key)) keys.remove(key)
    }

    fun contains(key: Int) = keys.contains(key)

}

/**

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


 */



data class MyNode(
    val key: Int,
    var value: Int
)

class MyHashMap() {
    //alternative solution would be using List<Pair<Int,Int>>
    private val myMap = mutableListOf<MyNode>()

    fun put(key: Int, value: Int) {
        var keyExists = false
        for (node in myMap) {
            if (node.key == key) {
                node.value = value
                keyExists = true
            }
        }
        if (!keyExists) myMap.add(MyNode(key, value))
    }

    fun get(key: Int): Int {
        for (node in myMap) {
            if (node.key == key) {
                return node.value
            }
        }
        return -1
    }

    fun remove(key: Int) {
        var value = 0
        var valueExists = false
        for (node in myMap) {
            if (node.key == key) {
                value = node.value
                valueExists = true
            }
        }
        if(valueExists) myMap.remove(MyNode(key, value))
    }

}

fun main() {
    val myHashMap = MyHashMap()
    myHashMap.put(1, 1) // The map is now [[1,1]]

    myHashMap.put(2, 2) // The map is now [[1,1], [2,2]]

    myHashMap.get(1) // return 1, The map is now [[1,1], [2,2]]

    myHashMap.get(3) // return -1 (i.e., not found), The map is now [[1,1], [2,2]]

    myHashMap.put(2, 1) // The map is now [[1,1], [2,1]] (i.e., update the existing value)

    myHashMap.get(2) // return 1, The map is now [[1,1], [2,1]]

    myHashMap.remove(2) // remove the mapping for 2, The map is now [[1,1]]

    myHashMap.get(2) // return -1 (i.e., not found), The map is now [[1,1]]

}