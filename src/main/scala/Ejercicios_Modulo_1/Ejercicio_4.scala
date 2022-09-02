package Ejercicios_Modulo_1

object Ejercicio_4 extends App {

  class PascalRowException extends Exception("Las filas en el triángulo comienzan a partir del número 1.")

  def pascalRow(rowNumber: Int): List[Int] = {

    if (rowNumber <= 0) throw new PascalRowException

    val sides: Int = 1

    def pascalRowGenerator(data: List[Int], supportIndex: Int = 0, supportList: List[Int] = List()): List[Int] = {
      if (supportIndex < (data.length - 1)) {
        pascalRowGenerator(
                            data,
                            supportIndex + 1,
                            supportList :+ (data(supportIndex) + data(supportIndex + 1))
                          )
      } else supportList
    }

    def pascalTriangle(index: Int = 1, pascalList: List[Int] = List(1)): List[Int] = {
      if (index < rowNumber) {
        pascalTriangle(
                      index + 1,
                      sides +: pascalRowGenerator(pascalList) :+ sides
                      )
      } else pascalList
    }

    pascalTriangle()

  }

  // AQUÍ COMIENZAN LAS PRUEBAS:
  val number_row = 12
  val pascalRowFetched = pascalRow(number_row)
  println(f"Pascal's Triangle Row $number_row : $pascalRowFetched")

}
