package Ejercicios_Modulo_2

import java.util.Date
import scala.collection.mutable.Map  // "mutable", dado que queremos eliminar también los modulos.

object Ejercicio_4 extends App {

  class commonCharacteristics (var moduloEncendido: Boolean) {

    val moduleName: String = this.getClass.getSimpleName
    val fechaDeCreacion: Date = new Date()

    def estadoModulo: String = {
      if (this.moduloEncendido)
        f"Módulo ${this.moduleName} en funcionamiento."
      else f"Módulo ${this.moduleName} apagado."
    }

    def encenderApagarModulo: Unit = {
      if (this.moduloEncendido)
        this.moduloEncendido = false
      else this.moduloEncendido = true
    }
  }

  class Ixtlilton (var mE: Boolean, val params: String*) extends commonCharacteristics(moduloEncendido=mE) {

    def tareaDiagnostico: Unit = {
      val executingTask = f"Ejecutando sistema de inspección con los parámetros: ${params.mkString(",")}"
      println(executingTask)
    }
  }

  class Yacatecuhtli (var mE: Boolean) extends commonCharacteristics(moduloEncendido=mE) {

    def tareaReconocimiento(numDrones: Int, territorio: String): Unit = {
      println(f"Desplegando $numDrones drones de reconocimiento en el territorio $territorio")
    }
  }

  class Quetzalcoatl (var mE: Boolean) extends commonCharacteristics(moduloEncendido=mE) {

    def tareaDefensiva: Unit = {
      if (this.moduloEncendido)
        println("Quetzalcóatl: Los sistemas de defensa se encuentran activos.")
      else println("Quetzalcóatl: Los sistemas de defensa se encuentran desactivados.")
    }
    override def encenderApagarModulo: Unit = {
      if (this.moduloEncendido) {
        this.moduloEncendido = false
        println("Quetzalcóatl: Sistemas de defensa desactivados.")
      } else {
        this.moduloEncendido = true
        println("Quetzalcóatl: Reactivando sistemas de defensa, tiempo estimado 1 minuto.")
      }
    }
  }

  object Coatlicue {
    val creationDate = new Date()
    val modulosInstances:Map[String, commonCharacteristics] = Map()  // Map mutable, para poder agregar, eliminar y
    // modificar modulos.
    def aniadirModulo(modulos: commonCharacteristics*): Unit = {
      for (modulo <- modulos){
        modulosInstances(modulo.moduleName) = modulo
      }
    }
    def eliminarModulo(modulo: commonCharacteristics) = {
      modulosInstances.remove(modulo.moduleName)
    }
    def representacionModulos = {
      println(f"Guardando el estado del componente : ('Coatlicue', ${creationDate})")
      modulosInstances.map(
        x => println(
                    f"Guardando el estado del componente : (${x._1}, ${x._2.fechaDeCreacion}, ${x._2.estadoModulo})"
                    )
      )
    }
  }

  val coat1 = Coatlicue
  // val coat2 = Coatlicue
  // println(coat1 == coat2)  // coat1 y coat2 son la misma instancia, por lo tanto se cumple el criterio de la
  //  existencia de una sola instancia.

//  val newMap: Map[Int, String] = Map(1 -> "one", 2 -> "two")
//  println(newMap)
//  val newMap2: Map[String, Int] = Map()
//  newMap2("firstModule") = 10
//  println(newMap2)


  // INICIAN PRUEBAS:
  val moduleIxtlilton = new Ixtlilton(true, "A", "B", "C")
//  moduleIxtlilton.tareaDiagnostico
//  println(moduleIxtlilton.moduloEncendido)
//  println(moduleIxtlilton.estadoModulo)  // método.
//  moduleIxtlilton.encenderApagarModulo
//  println(moduleIxtlilton.moduloEncendido)
//  moduleIxtlilton.tareaDiagnostico
//  println(moduleIxtlilton.estadoModulo)  // método.
//  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val moduleYacatecuhtli = new Yacatecuhtli(true)
//  moduleYacatecuhtli.tareaReconocimiento(118, "Namek")
//  println(moduleYacatecuhtli.moduloEncendido)
//  println(moduleYacatecuhtli.estadoModulo)  // método.
//  moduleYacatecuhtli.encenderApagarModulo
//  println(moduleYacatecuhtli.moduloEncendido)
//  moduleYacatecuhtli.tareaReconocimiento(118, "Namek")
//  println(moduleYacatecuhtli.estadoModulo)  // método.
//  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val moduleQuetzalcoatl = new Quetzalcoatl(true)
//  moduleQuetzalcoatl.tareaDefensiva
//  println(moduleQuetzalcoatl.fechaDeCreacion)
//  println(moduleQuetzalcoatl.moduloEncendido)
//  println(moduleQuetzalcoatl.estadoModulo)  // método.
//  moduleQuetzalcoatl.encenderApagarModulo
//  println(moduleQuetzalcoatl.moduloEncendido)
//  moduleQuetzalcoatl.tareaDefensiva
//  println(moduleQuetzalcoatl.estadoModulo)  // método.
//  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  coat1.aniadirModulo(moduleIxtlilton, moduleYacatecuhtli, moduleQuetzalcoatl)
  coat1.representacionModulos
  println()

  moduleQuetzalcoatl.encenderApagarModulo
  moduleIxtlilton.encenderApagarModulo
  coat1.representacionModulos
  println()

  coat1.eliminarModulo(moduleIxtlilton)  // Se elimina el modulo "Ixtlilton".
  coat1.representacionModulos

}
