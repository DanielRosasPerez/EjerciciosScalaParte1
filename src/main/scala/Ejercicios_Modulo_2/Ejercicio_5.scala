package Ejercicios_Modulo_2

object Ejercicio_5 extends App {

  def calcularPorcentaje(porcentaje: Double, tarjeta: String): Double => Double = {
    if (tarjeta.toLowerCase() == "azul")
      (x: Double) => x * porcentaje
    else (x: Double) => x * 2 * porcentaje
  }

  val calcularPuntosAzul = calcularPorcentaje(0.01, "azul")
  val calcularPuntosOro = calcularPorcentaje(0.02, "oro")

  println(calcularPuntosAzul(100))
  println(calcularPuntosOro(100))

}
