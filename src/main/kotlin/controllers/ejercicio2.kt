package org.example.controllers
import java.util.*
fun main(){
    print("Posa un numero :")
    var scanner=Scanner(System.`in`)
    var numero=scanner.nextInt()
    println(roman(numero))
}
fun obtenirRoman(num: Int):Pair<Int,String> {
    val valors = arrayOf(
        1000 to "M", 900 to "CM", 500 to "D", 400 to "CD",
        100 to "C", 90 to "XC", 50 to "L", 40 to "XL",
        10 to "X", 9 to "IX", 5 to "V", 4 to "IV",
        1 to "I"
    )
    for ((valor, simbol) in valors) {
        if (num >= valor) {
            return Pair(valor, simbol)
        }
    }
    return Pair(0, "")
}

fun roman(num:Int):String {
    var numero = num
    var resultat = StringBuilder()
    while (numero > 0) {
        val (valor, simbolo) = obtenirRoman(numero)
        resultat.append(simbolo)
        numero -= valor
    }
    return resultat.toString()
}









