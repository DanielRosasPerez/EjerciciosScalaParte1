package Ejercicios_Modulo_1

object Ejercicio_5 extends App {

  object guerrerosNormales extends Enumeration {
    type guerrerosNormales = Value

    val Arqueria = Value(1, "Arquero")
    val Caballeria = Value(2, "Caballero")
    val Infanteria = Value(3, "Soldado")
    val Polvora = Value(4, "Pólvora")
    val Camellos = Value(5, "Camello")
  }

  trait CaracteristicasComunesGuerreros {
    val nombre: String
    val identificador: Int
    var velocidad: Int
    var fuerzaAtaque: Int
    var fuerzaResistencia: Int

    def atacarOponente(oponente: CaracteristicasComunesGuerreros): Unit = {
      oponente.fuerzaResistencia -= this.fuerzaAtaque
    }
  }

  object unidadesUnicas extends Enumeration {
    type unidadesUnicas = Value

    val ArqueroTiroLargo = Value(1, "Arquero de tiro largo")
    val Paladin = Value(2, "Paladín")
    val Espadachin = Value(3, "Espadachín")
    val Husar = Value(4, "Usar")
    val GuerrorAguililla = Value(5, "Guerrero Aguililla")
  }

  case class aldeano(nombre: String, identificador: Int, capacidadTrabajo: Int, fuerzaResistencia: Int)

  class arqueros(
                override val nombre: String, override val identificador: Int,
                val TipoGuerrero: guerrerosNormales.Value, override var velocidad: Int = 5,
                override var fuerzaAtaque: Int = 15, override var fuerzaResistencia: Int = 32
                )
                extends CaracteristicasComunesGuerreros

  class caballeros(
                    override val nombre: String, override val identificador: Int,
                    val TipoGuerrero: guerrerosNormales.Value, override var velocidad: Int = 20,
                    override var fuerzaAtaque: Int = 22, override var fuerzaResistencia: Int = 24
                  ) extends CaracteristicasComunesGuerreros

  class infanteria(
                    override val nombre: String, override val identificador: Int,
                    val TipoGuerrero: guerrerosNormales.Value, override var velocidad: Int = 10,
                    override var fuerzaAtaque: Int = 8, override var fuerzaResistencia: Int = 12
                  ) extends CaracteristicasComunesGuerreros

  class polvora(
                 override val nombre: String, override val identificador: Int,
                 val TipoGuerrero: guerrerosNormales.Value, override var velocidad: Int = 100,
                 override var fuerzaAtaque: Int = 1000, override var fuerzaResistencia: Int = 0
               ) extends CaracteristicasComunesGuerreros

  class camellos(
                  override val nombre: String, override val identificador: Int,
                  val TipoGuerrero: guerrerosNormales.Value, override var velocidad: Int = 15,
                  override var fuerzaAtaque: Int = 12, override var fuerzaResistencia: Int = 18
                ) extends CaracteristicasComunesGuerreros

  class unidadUnica(
                     override val nombre: String, override val identificador: Int,
                     val TipoGuerrero: unidadesUnicas.Value, override var velocidad: Int,
                     override var fuerzaAtaque: Int, override var fuerzaResistencia: Int,
                     val bonusAtack: Int
                   ) extends CaracteristicasComunesGuerreros {
    override def atacarOponente(oponente: CaracteristicasComunesGuerreros) = {
      oponente.fuerzaResistencia -= (this.fuerzaAtaque + bonusAtack)
    }
  }

  case class civilizacion(nombre: String, aldeanos: Array[aldeano], guerreros: Array[CaracteristicasComunesGuerreros],
                          unidadUnica: unidadUnica)

  // COMIENZAN PRUEBAS:
  val newEspadachin = new arqueros("Pedro", 1, TipoGuerrero = guerrerosNormales.Arqueria)
  println(newEspadachin.nombre)
  println(newEspadachin.fuerzaAtaque)
  println(newEspadachin.fuerzaResistencia)
  println(newEspadachin.TipoGuerrero)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  val newCaballero = new caballeros("Daniel", 1, TipoGuerrero = guerrerosNormales.Caballeria)
  println(newCaballero.nombre)
  println(newCaballero.fuerzaAtaque)
  println(newCaballero.fuerzaResistencia)
  println(newCaballero.TipoGuerrero)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  println(newEspadachin.fuerzaResistencia)
  newCaballero.atacarOponente(newEspadachin)
  println(newEspadachin.fuerzaResistencia)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  val newAldeano = aldeano("Juancho", 1, 10, 4)
  println(newAldeano.nombre)
  println(newAldeano.capacidadTrabajo)
  println(newAldeano.fuerzaResistencia)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  val uUespadachin = new unidadUnica("Chaifs", 1, TipoGuerrero=unidadesUnicas.Espadachin,
                                    15, 18, 20, 5)
  println(uUespadachin.nombre)
  println(uUespadachin.identificador)
  println(uUespadachin.TipoGuerrero)
  println(uUespadachin.velocidad)
  println(uUespadachin.fuerzaAtaque)
  println(uUespadachin.fuerzaResistencia)
  println(uUespadachin.bonusAtack)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  println(newCaballero.fuerzaResistencia)
  uUespadachin.atacarOponente(newCaballero)
  println(newCaballero.fuerzaResistencia)
  println("~"*80)

  /* ----------------------------------------------------------------------------------------------------------- */
  val newCivilization = civilizacion(nombre="GeniusMen", aldeanos=Array(newAldeano),
                                     guerreros=Array(newCaballero), unidadUnica=uUespadachin)
  println(newCivilization.nombre)

}
