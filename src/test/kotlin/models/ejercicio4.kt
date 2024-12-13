import controllers.resultat
import controllers.main
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ejercicio4 {

    @Test
    fun testCentratText() {
        val text = "Hola"
        val textCentrat = resultat(text)

        // El resultat esperat ha de ser "  Hola    " centrat dins d'una línia de 80 caràcters.
        val expected = "                                    Hola                                    "

        // Comprovem que el text està centrat correctament
        assertEquals(expected, textCentrat)
    }

    @Test
    fun testTextBuit() {
        val textBuit = ""
        val textCentratBuit = resultat(textBuit)

        // El resultat esperat són 80 espais, ja que l'entrada és un text buit
        val expected = "                                                                                "

        // Comprovem que el resultat són només 80 espais
        assertEquals(expected, textCentratBuit)
    }
}
