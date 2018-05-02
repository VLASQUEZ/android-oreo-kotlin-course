/**
@autor Andrés Velasquez
@since 1/05/18
 **/

abstract class Animal(
  var hasOwner: Boolean,
  var ownerName: String
) {
  fun walk() = println("Caminando")

  //Abierto para sobrescribir el metodo
  abstract fun talk()
}