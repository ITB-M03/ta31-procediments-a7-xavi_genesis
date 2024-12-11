package models
import org.example.controllers.calcularIVA
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ejercicio1 {
    @Test
    fun testCalcularIVA_general() {
        val esperado = 118.0
        val precioConIVA = calcularIVA(100.00, "general", "01-01-2010")
        assertEquals(esperado, precioConIVA)
    }

    @Test
    fun testCalcularIVA_reduit() {
        val esperado = 214.0
        val precioConIVA = calcularIVA(200.0, "reduït", "01-01-1995")
        assertEquals(esperado, precioConIVA)
    }

    @Test
    fun testCalcularIVA_superreduït() {
        val esperado = 156.0
        val precioConIVA = calcularIVA(150.0, "superreduït","01-01-1995")
        assertEquals(esperado, precioConIVA)
    }

    @Test
    fun testCalcularIVA_exempt() {
        val esperado = 300.0
        val precioConIVA = calcularIVA(300.0, "exempt", "01-01-2010")
        assertEquals(esperado, precioConIVA)
    }
}