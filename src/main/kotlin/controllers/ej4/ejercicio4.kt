package controllers.ej4
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Escriu un text per centrar-lo: ")
    val inputText = scanner.nextLine()

    // mostra el text centrat
    titol(inputText)
}

/**
 * @author sergionavas
 * mostra un text centrat en una línia de 80 caracters
 * @param text el text que es vol centrar
 */
fun titol(text: String) {
    println(resultat(text))
}

/**
 * text centrat per una línia de 80 caràcters d'amplada
 * @param text el text que es vol centrar
 * @return el text centrat
 */
fun resultat(text: String): String {
    val espais = (80 - text.length).coerceAtLeast(0) / 2
    return " ".repeat(espais) + text
}
