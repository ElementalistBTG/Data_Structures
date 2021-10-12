class ReverseArrayClass {

    fun reverse(str: String): String {
        //check input


        //val strArray = str.map { it.toString() }.toTypedArray()

        val backwards: Array<Char?> = arrayOfNulls<Char>(str.length)

        for (i in str.indices) {
            backwards[i] = str[str.length - 1 - i]
            //backwards[i]= strArray[str.length-1-i]
        }

        return backwards.joinToString("")

    }
}