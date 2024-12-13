package controllers

import org.example.controllers.obtenirRoman
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
 class Ej2KtTest {

  @Test
  fun obtenirRoman() {

   val (valor, simbol) = obtenirRoman(0)
   assertEquals(1000, valor)
   assertEquals("M", simbol)
  }
 }


