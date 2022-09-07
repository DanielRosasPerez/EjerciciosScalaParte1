package Ejercicios_Modulo_2

object Ejercicio_4 extends App {

  class commonCharacteristics (var moduloEncendido: Boolean) {

    def estadoModulo(moduleName: String): Unit = {
      if (this.moduloEncendido)
        println(f"Módulo $moduleName en funcionamiento.")
      else println(f"Módulo $moduleName apagado.")
    }

    def encenderApagarModulo: Unit = {
      if (this.moduloEncendido)
        this.moduloEncendido = false
      else this.moduloEncendido = true
    }
  }

  class Ixtlilton (var mE: Boolean, val params: String*) extends commonCharacteristics(moduloEncendido=mE) {
    val moduleName: String = this.getClass.getSimpleName

    def tareaDiagnostico: Unit = {
      val executingTask = f"Ejecutando sistema de inspección con los parámetros: ${params.mkString(",")}"
      println(executingTask)
    }
  }

  class Yacatecuhtli (var mE: Boolean) extends commonCharacteristics(moduloEncendido=mE) {
    val moduleName: String = this.getClass.getSimpleName

    def tareaReconocimiento(numDrones: Int, territorio: String): Unit = {
      println(f"Desplegando $numDrones drones de reconocimiento en el territorio $territorio")
    }
  }

  class Quetzalcoatl (var mE: Boolean) extends commonCharacteristics(moduloEncendido=mE) {
    val moduleName: String = this.getClass.getSimpleName

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

//  class Coatlicue private[Coatlicue] {}
//  object Coatlicue {
//    def apply: Unit = new Coatlicue
//  }
//
//  val coat1 = new Coatlicue()
//  val coat2 = new Coatlicue()

  // INICIAN PRUEBAS:
  val moduleIxtlilton = new Ixtlilton(true, "A", "B", "C")
  moduleIxtlilton.tareaDiagnostico
  println(moduleIxtlilton.moduloEncendido)
  moduleIxtlilton.estadoModulo(moduleIxtlilton.moduleName)
  moduleIxtlilton.encenderApagarModulo
  println(moduleIxtlilton.moduloEncendido)
  moduleIxtlilton.tareaDiagnostico
  moduleIxtlilton.estadoModulo(moduleIxtlilton.moduleName)
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val moduleYacatecuhtli = new Yacatecuhtli(true)
  moduleYacatecuhtli.tareaReconocimiento(118, "Namek")
  println(moduleYacatecuhtli.moduloEncendido)
  moduleYacatecuhtli.estadoModulo(moduleYacatecuhtli.moduleName)
  moduleYacatecuhtli.encenderApagarModulo
  println(moduleYacatecuhtli.moduloEncendido)
  moduleYacatecuhtli.tareaReconocimiento(118, "Namek")
  moduleYacatecuhtli.estadoModulo(moduleYacatecuhtli.moduleName)
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  val moduleQuetzalcoatl = new Quetzalcoatl(true)
  moduleQuetzalcoatl.tareaDefensiva
  println(moduleQuetzalcoatl.moduloEncendido)
  moduleQuetzalcoatl.estadoModulo(moduleQuetzalcoatl.moduleName)
  moduleQuetzalcoatl.encenderApagarModulo
  println(moduleQuetzalcoatl.moduloEncendido)
  moduleQuetzalcoatl.tareaDefensiva
  moduleQuetzalcoatl.estadoModulo(moduleQuetzalcoatl.moduleName)
  println()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
