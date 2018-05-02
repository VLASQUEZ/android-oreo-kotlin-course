/**
@autor Andrés Velasquez
@since 1/05/18
 **/

//Las clases en kotlin son final por defecto
class Dog(
  val name: String,
  var age: Int,
  val race: String
) : Animal(false, "Ninguno") {
  companion object {

    fun creaPerro(): Dog = Dog("perro 2", "desconocida")
  }

  constructor(
    name: String,
    race: String
  ) : this(name, 0, race)

  override fun talk() = println("Guau Guau")
}