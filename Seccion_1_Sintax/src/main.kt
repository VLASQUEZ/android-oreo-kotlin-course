/**
@autor Andrés Velasquez
@since 29/04/18
 **/


fun main(args: Array<String>){
  println("Hello world")

  //stringTemplate()
  //conditions()
  //switchCondition()
  //arrays()

  val num1 = 4
  val num2 = 8

  val result = onLineFUnc(num1 = num1 ,num2 = num2)

  println(result)


  val numeros = intArrayOf(1,2,3,4,5,6)

  numeros.extensionFunc(0, 4)

  println(numeros[0])



  var resta = 6 menos 3

  println("Resultado funcion INFIX: $resta")
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

/**
 * Nullables Optionals & Required
 */
fun nullable (){
  var value : String? = null


  //  SAFE CALL OPERATOR => ?
  // REQUIRED OPERATOR !!
  var value2 : String = value!!

}

/**
 * One lien func
 */
fun onLineFUnc(num1 : Int, num2 : Int): Int = num1 + num2

/**
 * funciones de extension
 */
fun IntArray.extensionFunc(indx1: Int, indx2 : Int){
  val temp = this[indx1]

  this[indx1] = this[2]

  this[indx2] = temp
}

/**
 * Funciones Infix
 *
 * Restricciones:
 * 1. Miembros de una clase o funciones de extension
 * 2. Deben tener un parametro
 * 3. Deben estar marcadas por la palabra infix
 */
 infix fun Int.menos(num: Int) = this - num