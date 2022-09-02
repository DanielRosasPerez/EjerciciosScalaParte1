package Ejercicios_Modulo_1

object Ejercicio_3 extends App {

  val EncryptionDictionary = Map('a' -> 'L', 'e' -> '9', 'i' -> '$', 'o' -> 'R', 'u' -> '4')
  // println(EncryptionDictionary('a'))
  // println(EncryptionDictionary.get('c'))

  val newLst: List[Char] = List('a','b','e','$','g','i')
  // println(newLst.map(x => EncryptionDictionary.get(x)))
  // println(newLst.filter(x => EncryptionDictionary.contains(x)))
  // println(newLst.filter(x => EncryptionDictionary.contains(x)).map(y => EncryptionDictionary(y)))

  def encryptVowel(vowelsList: List[Char]): List[Char] = {
    vowelsList
      .filter(x => EncryptionDictionary.contains(x))
      .map(y => EncryptionDictionary(y))
  }

  println(encryptVowel(List('a', 'i', 'e', 'a')))
  println(encryptVowel(List('a')))
  println(encryptVowel(List('i', 'e')))
  println(encryptVowel(newLst))

}
