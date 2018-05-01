/**
@autor Andrés Velasquez
@since 1/05/18
 **/

class Casting {
 companion object {
   fun insecureCasting(obj : Any){
     // El operador de casteo inseguro es as
     val string = obj as String

     println(string.length)
   }
   fun secureCastring(obj : Any){

     //Tener en cuenta el operador ? que permite asignar valores null a variables
     val string:String? = obj as? String
     //Si el operador as? no puede convertir el objeto a cadena al momento de llamar la funcion
     //println() devolverá null
     println(string?.length)
   }
 }
}