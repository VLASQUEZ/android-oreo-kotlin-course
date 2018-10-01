import kotlin.math.abs

/**
@autor Andrés Velasquez
@since 30/09/18
 **/
fun main(args: Array<String>){
  var mutableList= mutableListOf<Int>(2, 1, 3, 5, 3, 2)
  println(Playground.firstDuplicate(mutableList))

}
class Playground {


  companion object {


    fun firstDuplicate(arr: MutableList<Int>): Int {

      for (i in 0 until arr.size) {
        val value = Math.abs(arr[i])

        if (arr[value - 1] < 0) return value

        arr[value - 1] = -arr[value - 1]
      }
      return -1

    }
  }
}