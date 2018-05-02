/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class LamdaExpression {
  companion object {
    fun pairNumbersLamda() {
      val pairNumber1 = Array(30, { indx -> indx * 2 })

      //it hace referencia al parametro de entrada de la funcion lamda
      //solo es valido si la funcion solo tiene un parametro
      val pairNumber2 = Array(30, { it * 2 })
    }
  }
}