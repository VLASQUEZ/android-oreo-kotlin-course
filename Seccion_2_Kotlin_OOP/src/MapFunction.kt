/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class MapFunction {
  companion object {
    fun mapFunc() {
      val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8)

      val duplyNumbers = numeros.map {
        it * 2
      }
      for (number in duplyNumbers) {
        println(number)
      }

    }

  }

}