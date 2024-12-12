package models
import Pila
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ejercicio5 {
    @Test
    fun testPush(){
        val pila = Pila()
        pila.push(5)
        pila.push(10)
        assertEquals(5, pila.piles[0])
        assertEquals(10, pila.piles[1])
    }

    @Test
    fun testPush2() {
        val pila = Pila()
        repeat(10){
            pila.push(it)
        }
        assertEquals(9, pila.piles[9])
        assertEquals(9, pila.primer)
    }

    @Test
    fun testPop() {
        val pila = Pila()
        pila.pop()
        assertEquals(-1, pila.primer)
    }
    @Test
    fun testPop2() {
        val pila = Pila()
        repeat(5){
            pila.push(it)
        }
        assertEquals(4,pila.primer)
    }

}