package org.example.controllers
import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    menu()

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





