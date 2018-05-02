/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class AnonymFunc {

  companion object {
    /**
     * Funcion Anonima
     */
    val myFunc = fun() = println("Funcion anonima")

    fun execAnonymFunc() {
      myFunc.invoke()
    }

    fun execPairNumbers() {
      val myFuncPairs = fun(indx: Int): Int {
        return indx * 2
      }

      val pairNumber = Array(10, myFuncPairs)

      for (number in pairNumber) {
        println("$number")
      }
    }
  }

}