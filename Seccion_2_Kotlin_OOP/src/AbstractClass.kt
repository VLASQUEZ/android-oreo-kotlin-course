/**
 * @author Andres Velasquez
 * @since 2/05/18
 */

/**
 * T tipo de dato generico
 */
class AbstractClass<T>(content: T) {
  val content: T = content
}

class ObjAbstract {

  fun fillBox() {
    val box: AbstractClass<Int> = AbstractClass(3)

    println(box)
  }
}