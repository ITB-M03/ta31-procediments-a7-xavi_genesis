package models
import controllers.comprovarPassword
import controllers.determinarSiEsValido
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ejercicio3 {
    @Test
    fun testPasswordCorrecta() {
        val resultat = determinarSiEsValido(true)
        assertEquals("¡Contraseña correcta!", resultat)
    }

    @Test
    fun testPasswordIncorrecta() {
        val resultat = determinarSiEsValido(false)
        assertEquals("Has agotado los 3 intentos, inténtalo de nuevo", resultat)
    }

}