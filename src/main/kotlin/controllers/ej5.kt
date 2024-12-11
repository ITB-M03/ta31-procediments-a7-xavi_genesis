package org.example.controllers
import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    menu()

}

class pila (val capacitat: Int = 10) {
    var piles = (Array(capacitat) { 0 })
    var primer = -1


    fun push(numero: Int): Boolean {
        var resultado: Boolean
        if (numero >= capacitat - 1) {
            piles += numero
            resultado = true
        } else {
            println("La pila es buida")
            resultado = false
        }
        return resultado
    }

    fun pop(numero: Int): Boolean {
        var resultado: Boolean
        if (piles.size >= 11) {
            resultado = false
        } else {
            piles.drop(numero)
            resultado = true
        }
        return resultado
    }

    fun mostrar(): Boolean{
        var resultado: Boolean
        if (piles.isEmpty()){ println("La pila está vacía")
            resultado = false}
        else {println(piles.toString())
            resultado = true}
        return resultado
    }


}

fun mostrarMenu() {

    println("1.Afegir numero ")
    println("2.Treure número ")
    println("3.Mostrar contingut de la pila ")
    println("4. Sortir")
    print("Escull una opcio:")
}
fun menu(){
    val scanner= Scanner(System.`in`)
    mostrarMenu()
    var continuar= true

    while(continuar){


        val opcio= scanner.nextInt()
        when(opcio){
            1-> print("Afegeix el numero:")
            2-> print("hgh")
            3-> print("La pila esta")
            4-> {
                println("Adeu.")
                continuar=false

            }
            else-> {
                println("Valor invadid")
                continuar = false
            }

        }

    }


}





