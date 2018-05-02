/**
@autor Andrés Velasquez
@since 1/05/18
 **/

fun main(args: Array<String>) {
  val perrito = Dog("Apolo", "Labrador")
  print(
      "${perrito.name} tiene ${perrito.age} años y es un ${perrito.race} su dueño es: ${perrito.ownerName}"
  )
}

/**
Modificadores
 */

//TODO LO QUE NO TENGA MODIFICADOR DE ACCESO , ES POR DEFECTO PUBLIC
//public
//private
//internal Solamente puede ser accesada dentro del mimso modulo
//protected