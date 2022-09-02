package Ejercicios_Modulo_1


object Ejercicio_1 extends App {

  class MuggleException extends Exception("Eres Muggle")

  val Griffindor: List[String] = List("coraje", "osadia", "temple", "caballerosidad")
  val Hufflepuff: List[String] = List("amigable", "leal", "trabajador")
  val Ravenclaw: List[String] = List("sabiduría", "ingenio", "intelecto")
  val Slytherin: List[String] = List("ambicioso", "inteligente", "astuto", "líder")

  def sombreroSeleccionador(caracteristica: String): String = {
    if (Griffindor.contains(caracteristica.toLowerCase())) "Griffindor"
    else if (Hufflepuff.contains(caracteristica.toLowerCase())) "Hufflepuff"
    else if (Ravenclaw.contains(caracteristica.toLowerCase())) "Ravenclaw"
    else if (Slytherin.contains(caracteristica.toLowerCase())) "Slytherin"
    else throw new MuggleException
  }

  for (atributo <- List("astuto", "osadia", "trabajador", "wapo", "inteligente", "sabiduría")) {
    try {
      println("~"*80)
      println(f"Atributo : $atributo")
      println(f"Escuela : ${sombreroSeleccionador(atributo)}")
    } catch {
      case e: MuggleException =>
        println("Muggle")
    }
  }

  println("*"*120)

  for (atributo <- List("amigable", "temple", "wapo")) {
    println("-" * 40)
    println(f"Atributo : $atributo")
    println(f"Escuela : ${sombreroSeleccionador(atributo)}")
  }

}
