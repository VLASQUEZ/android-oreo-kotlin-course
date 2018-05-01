/**
@autor Andrés Velasquez
@since 1/05/18
 **/
class Reflection {
  companion object {
    fun getClassName(obj : Any){
      val nombreclase = obj::class
      println("El objeto pertenece a la clase: $nombreclase")
    }
  }
}