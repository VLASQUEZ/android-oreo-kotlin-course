package models

/**
 * @author Andres Velasquez
 * @since 2/05/18
 */

/**
 * Una data class se usa con el objetivo de recibir y guardar informacion
 */
data class Person(
  var nombre: String,
  var apellidoPaterno: String,
  var apellidoMaterno: String,
  var edad: Int
) {
  /**
   * Sobrecarga de operadores (Operation Overloading)
   */

  operator fun plus(person: Person): Person {
    return Person("", this.apellidoPaterno, person.apellidoMaterno, 0)
  }
}