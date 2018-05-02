import models.Dog
import models.Person

/**
@autor Andrés Velasquez
@since 1/05/18
 **/

fun main(args: Array<String>) {
  val perrito = Dog("Apolo", "Labrador")
  println(
      "${perrito.name} tiene ${perrito.age} años y es un ${perrito.race} su dueño es: ${perrito.ownerName}"
  )
  //Sobrecarga de operadores
  val hijo = Person("pepe", "lota", "", 20) +
      Person("pancha", "mora", "rosa", 24)

  println(hijo)
  //Funciones Anonimas
  AnonymFunc.execPairNumbers()
}

/**
Modificadores
 */

//TODO LO QUE NO TENGA MODIFICADOR DE ACCESO , ES POR DEFECTO PUBLIC
//public
//private
//internal Solamente puede ser accesada dentro del mimso modulo
//protected