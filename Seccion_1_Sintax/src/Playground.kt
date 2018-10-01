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

    fun firstDuplicate(a: MutableList<Int>): Int {

      var result = -1

      for (i in 0 until a.size - 1)
        if (a[abs(a[i])-1] < 0 ) {
          result = a[i]
          break
        }
        else{
          a[abs(a[i])-1] = -a[abs(a[i])-1]
        }

      // optional restore the negative numbers back to positive
      for (i in 0 until a.size - 1)
        if (a[i] < 0){
          a[i] = -a[i]
        }

      return result * -1

    }
  }
}