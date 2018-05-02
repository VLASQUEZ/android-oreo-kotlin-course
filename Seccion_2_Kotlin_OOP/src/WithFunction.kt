import models.Person

/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class WithFunction {
  companion object {
    fun withFunc() {
      val persona = Person("Juan", "Perez", "Hernandez", 23)

      //La funcion with recibe como parametro una variable y permite obviar el this.
      //Al momento de setear las propiedades de una variable
      with(persona) {
        val nombre = nombre
        val apellidoPaterno = apellidoPaterno
        val apellidoMaterno = apellidoMaterno
        val edad = edad
      }
    }
  }

}
