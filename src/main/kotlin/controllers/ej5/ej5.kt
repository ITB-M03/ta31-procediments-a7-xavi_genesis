package controllers.ej5
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val pila = Pila()
    menu(pila, scanner)
}
/**
 * Classe pila amb les seves respectives funcions
 *
 * @property capacitat La capacitat màxima de la pila
 */
class Pila(val capacitat: Int = 10) {
    val piles = Array(capacitat) { 0 }
    /**
     * Índex que és l'últim element afegit a la pila, Si és -1, la pila està buida
     */
    var primer = -1

    /**
     * Afegeix un número a la pila.
     *
     * @param numero El número que es vol afegir.
     * Si la pila està plena mostra un missatge "la pila és plena!"
     */
    fun push(numero: Int) {
        if (primer < capacitat - 1) {
            primer++
            piles[primer] = numero
        } else {
            println("La pila és plena!")
        }
    }

    /**
     * Elimina l'últim número afegit
     *Si la pila està buida mostra un missatge "la pila és buida!"
     */
    fun pop() {
        if (primer >= 0) {
            piles[primer] = 0 // Opcional: buidar l'última posició
            primer--
        } else {
            println("La pila és buida!")
        }
    }

    /**
     * Mostra els elements actuals de la pila.
     * Si la pila està buida, mostra un missatge "La pila és buida!"
     */
    fun mostrar() {
        if (primer == -1) {
            println("La pila és buida!")
        } else {
            for (i in 0..primer) {
                print("${piles[i]} ")
            }
            println()
        }
    }
}

/**
 * Imprimeix un Menú d'opcions
 */
fun mostrarMenu() {
    println("Qué operació vols fer?")
    println("1. Afegir número ")
    println("2. Treure número ")
    println("3. Mostrar contingut de la pila")
    println("4. Sortir")
    print("Escull una opció: ")
}

/**
 * Menú que gestiona les opcions disponibles
 *
 * @param pila la clase pila
 * @param scanner scanner per llegir opcions i numeros a afegir
 */
fun menu(pila: Pila, scanner: Scanner) {
    var continuar = true
    while (continuar) {
        mostrarMenu()
        val opcio = scanner.nextInt()
        when (opcio) {
            1 -> {
                print("Afegeix el numero: ")
                val numero = scanner.nextInt()
                pila.push(numero)
            }
            2 -> pila.pop()
            3 -> pila.mostrar()
            4 -> {
                println("Adeu!")
                continuar = false
            }
            else -> println("Valor inválid")
        }
    }
}
