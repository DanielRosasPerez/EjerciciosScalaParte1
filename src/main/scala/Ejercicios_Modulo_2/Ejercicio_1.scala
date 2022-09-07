package Ejercicios_Modulo_2

import scala.io.Source
import scala.util.control.Breaks.{breakable, break}

object Ejercicio_1 extends App {

  def parseFile(pathToFile: String) {
    val csvFile = Source.fromFile(pathToFile)
    var index: Int = 0
    breakable {
      for (line <- csvFile.getLines()) {
        if (index > 0) {
          val location = line.split(",")(1)
          val price = line.split(",")(2)
          if (location.nonEmpty && price.nonEmpty) {
            println(f"Location : $location | Price : $price")
          }
        }
        index += 1
      }
    }
    csvFile.close()
  }

  val filePath: String = raw"C:\\Users\\XMX7500\\Desktop\\Indra_Docs\\Precurso_Datio\\Docs_Examen\\RealEstate.csv"
  parseFile(pathToFile=filePath)

}
