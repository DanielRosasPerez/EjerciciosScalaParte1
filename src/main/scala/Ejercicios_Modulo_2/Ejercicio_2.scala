package Ejercicios_Modulo_2

import scala.util.{Failure, Success, Try}

object Ejercicio_2 extends App {

  val index: Int = 0
  def countCharacters(word: String): Int = {
    word match {
      case "" =>
        println("Your string is EMPTY.")
        0
      case null =>
        println("Your string is NULL.")
        0
      case _ =>
        def supportFunction(index: Int, word: String): Int = {
          try {
            word.substring(index, index + 1)
            supportFunction(index + 1, word)
          } catch {
            case e: StringIndexOutOfBoundsException =>
              index
          }
        }
        supportFunction(index, word)
    }
  }

  // COMIENZAN LAS PRUEBAS:
  val newString = "hola mundo"
//  println(newString.substring(0,0+1))
//  println(newString.substring(3,6+1))
//  println(newString.charAt(3))
//  println(newString(3))
  println(f"Quantity of chars from '$newString' : ${countCharacters(newString)}")
  println()

  val scndString = ""
  println(countCharacters(scndString))
  println()

  val thirdString = null
  println(countCharacters(thirdString))
  println()

}
