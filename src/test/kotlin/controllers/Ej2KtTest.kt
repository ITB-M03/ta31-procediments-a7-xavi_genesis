package controllers

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
 class Ej2KtTest {

  @Test
  fun obtenirRoman() {

   val (valor, simbol) = controllers.ej2.obtenirRoman(0)
   assertEquals(1000, valor)
   assertEquals("M", simbol)
  }
 }


