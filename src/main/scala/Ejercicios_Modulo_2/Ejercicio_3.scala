package Ejercicios_Modulo_2

object Ejercicio_3 extends App {

  class parentClass

  case class Celular(IMEI: String, SIM: String, Marca: String) extends parentClass
  case class Laptop(Serie: String, versionSO: String) extends parentClass
  case class Tablet(DNI: String, Modelo: String) extends parentClass

  case class NaveEspacial(Serie: String, Propulsores: Int, Ingenieros: Array[String]) extends parentClass

  class DispositivoException extends Exception("¡Este dispositivo no pertence a los Gadgets!")

  def imprimirCaracteristicas(gadgetInstance: parentClass): String = {
    gadgetInstance match {
      case Celular(imei, sim, marca) =>
        if (marca.toLowerCase() == "iphone") {
          f"IMEI : $imei | SIM : $sim"
        } else "Tu cel no es iPhone, rey! No te puedo autorizar la vista al IMEI y al SIM principe."
      case Laptop(serie, versionSO) =>
        f"Serie : $serie | S.O : $versionSO"
      case Tablet(dni, modelo) =>
        f"DNI : $dni | Modelo : $modelo"
      case _ =>
        throw new DispositivoException
    }
  }

  // COMIENZAN LAS PRUEBAS:
  val iphone = Celular("860253148568789", "At&t", "iPhone")
  println(imprimirCaracteristicas(iphone))

  val nokia = Celular("025867893164885", "izzi", "Nokia")
  println(imprimirCaracteristicas(nokia))
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val lap1 = Laptop("165181683MK", "38687")
  println(imprimirCaracteristicas(lap1))

  val lap2 = Laptop("165181683MK", "13867")
  println(imprimirCaracteristicas(lap2))
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val tablet1 = Tablet("BAA000589", "iPad")
  println(imprimirCaracteristicas(tablet1))

  val tablet2 = Tablet("00000010532", "Samsung S3")
  println(imprimirCaracteristicas(tablet2))
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val naveEspacial = NaveEspacial("15ABK58", 13, Array("Daniel Rosas", "Juancho Cárdenas", "Gabriela Márquez"))
  println(imprimirCaracteristicas(naveEspacial))

}
