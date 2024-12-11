package controllers

import java.util.Scanner

fun main() {
    val scan = abrirScaner()
    val contrasenya = validarSuperusuari(scan)
    val determinar = determinarSiEsValido(contrasenya)
    imprimirResultado(determinar)
    cerrarScaner(scan)
}

/**
 * Función que evalúa si la contraseña guardada en la variable constante es correcta
 * @param scan recibe el scanner que leerá la contraseña
 * @return devuelve si es correcta o no
 */
fun validarSuperusuari(scan: Scanner): Boolean {
    var comprovar: Boolean
    val contrasenaSecreta = "admin123"
    comprovar = comprovarPassword("Introduce la contraseña: ", contrasenaSecreta, scan)
    return comprovar
}

/**
 * Funcion que utiliza un bucle while para determinar cuantos intentos quedan
 * @param password recibe la contraseña de la variable interna constante
 * @return devuelve si es correcta o se agotaron los intentos antes
 */
fun comprovarPassword(msg: String, password: String, scan: Scanner): Boolean {
    var intentos = 0
    val maxIntentos = 3
    var correcto = false
    while (intentos < maxIntentos && !correcto) {
        print(msg)
        val contrasenya = scan.nextLine()
        if (contrasenya == password) correcto = true
        else println("Contraseña incorrecta, inténtalo otra vez")
        intentos++
    }
    return correcto
}

/**
 * Función que determina si agotó los 3 intentos
 * @return devuelve el resultado
 */
fun determinarSiEsValido(correcto: Boolean): String {
    var resultado: String
    if (correcto) resultado = "¡Contraseña correcta!"
    else resultado = "Has agotado los 3 intentos, inténtalo de nuevo"
    return resultado
}

fun imprimirResultado(resultat: String) {
    print(resultat)
}

fun abrirScaner(): Scanner {
    val scan = Scanner(System.`in`)
    return scan
}

fun cerrarScaner(scan: Scanner) {
    scan.close()
}
