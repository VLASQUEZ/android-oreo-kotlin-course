/**
@autor Andrés Velasquez
@since 29/04/18
 **/


fun main(args: Array<String>){
  println("Hello world")

  stringTemplate()
  conditions()
  switchCondition()
  arrays()

}

/**
 * StringTemplate Kotlin
 */
fun stringTemplate(){

  val name : String = "Andres"
  val lastname : String = "Velasquez"
  println("Hola soy $name y mi apellido es $lastname")

}

/**
 * IF/ELSE conditions kotlin
 */
fun conditions() {
  val value: Int = 3

  if (value < 3) {
    println("El numero es menor a 3")
  } else {
    println("El numero es mayor o igual a 3")
  }
}

/**
 * WHEN (Switch)
 */
fun switchCondition(){

  val value : Int = 3

  when(3){
    1 -> println("es 3")
    2 -> println("es 2")
    4,5 -> println("es 4 o 5")
    else -> println("es 3")
  }
}

/**
 * Arrays
 */
fun arrays(){
  val arreglo: Array<Int> = arrayOf(1,2,3,4,5,6)

  // Inicializar arreglos sin datoss
  val arrayNulls = arrayOfNulls<String>(5)
  val array : Array<String>
  cicloFor(arreglo)
  cicloWhile(arreglo)
}

/**
 * Ciclos kotlin
 */
fun cicloFor(array: Array<Int>){
  for(element  in array ){
    println(element)
  }

  for (index in array.indices){
    println(array[index])
  }
}

fun cicloWhile(array: Array<Int>){
  var indx: Int = 0
  while (indx <= array.size -1){
    println(array[indx])
    ++indx
  }

}