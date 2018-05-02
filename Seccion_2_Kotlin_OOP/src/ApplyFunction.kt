import models.Person

/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class ApplyFunction {
  fun Apply() {
    val person = Person("Andres", "Velasquez", "Pineda", 25)

    /**
     * Permite cambiar rapidamente las propiedades de un objeto de forma mas legible
     */
    person.apply {
      nombre = "pepe"
      apellidoPaterno = "lota"
      apellidoMaterno = "abc"
      edad = 26
    }
  }
}