package Ejercicios_Modulo_1

object Ejercicio_2 extends App {

  def AdditionNums(nums: Seq[Int], index: Int = 0): Int = {
    if (index < nums.length) {
      nums(index) + AdditionNums(nums, index + 1)
    } else 0
  }

  def mainFunction(SecondaryFunction: (Seq[Int], Int) => Int, numbers: Int*): Int = {
    SecondaryFunction(numbers, 0)
  }

  val sumResult: Int = mainFunction(AdditionNums, 1,2,3)
  println(f"Addition Result : $sumResult")

}
