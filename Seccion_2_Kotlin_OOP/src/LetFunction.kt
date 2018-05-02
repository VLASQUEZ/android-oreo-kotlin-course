import models.Person

/**
 * @author Andres Velasquez
 * @since 2/05/18
 */
class LetFunction {
  companion object {
    fun withFunc() {
      val persona: Person? = Person("Juan", "Perez", "Hernandez", 23)

      //La funcion let permite hacer lo mismo que with pero solo para cuando el objeto puede ser un nullable
      //Al momento de setear las propiedades de una variable
      persona?.let {
        val nombre = it.nombre
        val apellidoPaterno = it.apellidoPaterno
        val apellidoMaterno = it.apellidoMaterno
        val edad = it.edad
      }
    }
  }
}