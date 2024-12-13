package org.example.controllers
import java.util.*
fun main(){
    print("Posa un numero :")
    var scanner=Scanner(System.`in`)
    var numero=scanner.nextInt()
    println(roman(numero))
}
/**
 * @author sergionavas
 * converteix un numero enter a un parell que conté el valor i el simbol romà corresponent
 *
 * @param num el número que es convertira a roma
 * @return un parell (valor, simbol) on 'valor' és la quantitat que representa el simbol roma
 *         i 'simbol' es el caracter o grup de caracters romans
 */
fun obtenirRoman(num: Int):Pair<Int,String> {
    val valors = arrayOf(
        1000 to "M", 900 to "CM", 500 to "D", 400 to "CD",
        100 to "C", 90 to "XC", 50 to "L", 40 to "XL",
        10 to "X", 9 to "IX", 5 to "V", 4 to "IV",
        1 to "I"
    )
    // iterem sobre els valors per trobar el corresponent al numero donat
    for ((valor, simbol) in valors) {
        if (num >= valor) {
            return Pair(valor, simbol)
        }
        // en cas de no trobar cap valor (el qual no hauria de passar), retornem un parell buit
        return Pair(0, "")
    }
    return Pair(0, "")
}
/**
 * @author sergionavas
 * Converteix un número enter en la seva representació com a número romà.
 *
 * @param num El número que es convertirà a romà.
 * @return Una cadena de text amb la representació romana del número.
 */
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









