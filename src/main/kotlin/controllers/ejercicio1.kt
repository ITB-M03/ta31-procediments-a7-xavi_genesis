package controllers
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.*

fun main() {
    val scan = abrirScaner()
    val precio = pedirPrecio("Introduce un precio: ", scan)
    val tipoIVA = pedirTipoIVA("Introduce el tipo de IVA: ", scan)
    val fecha = pedirFecha("Introduce la fecha del pedido: ", scan)
    val calcular = calcularIVA(precio, tipoIVA, fecha)
    imprimiResutado(calcular)
    cerrarScaner(scan)

}
/**
 * Clase con los diferentes periodos de IVA con sus tasas
 * @property dataInici La fecha a partir se aplica las diferentes tasas de IVA
 * @property general El IVA general
 * @property reduit El IVA reducido
 * @property superReduit El IVA superreducido
 * @property exempt El IVA exento
 */
enum class IVA(dataInici: String, val general: Double, val reduit: Double, val superReduit: Double, val exempt: Double = 0.0) {
    IVA1986("01-01-1986", 0.12, 0.06, 0.0, 0.0),
    IVA1992("01-01-1992", 0.15, 0.06, 0.0, 0.0),
    IVA1993("01-01-1993", 0.15, 0.06, 0.03, 0.0),
    IVA1995("01-01-1995", 0.16, 0.07, 0.04, 0.0),
    IVA2010("01-01-2010", 0.18, 0.08, 0.04, 0.0),
    IVA2012("15-07-2012", 0.21, 0.10, 0.04, 0.0);
    val DataIniciADate: LocalDate = LocalDate.parse(dataInici, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
}

/**
 * Función que buscará entre la clase IVA sus tasas correspondientes
 * @param date recibe la fecha como localdate
 * @return devuelve las tasas que corresponden a la fecha
 */
fun buscarFechaIVA(date: LocalDate): IVA {
    var resultado: IVA
    resultado = IVA.entries.last { it.DataIniciADate <= date }
    return resultado
}

/**
 * Función que calcula el iva
 * @param precio precio incial
 * @param tipoIVA tipo de IVA
 * @param fechaCompra fecha de la compra
 * @return devuelve el precio total con el IVA incluido
 */
fun calcularIVA(precio: Double, tipoIVA: String, fechaCompra: String): Double {
    val fecha = LocalDate.parse(fechaCompra, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    val iva = buscarFechaIVA(fecha)
    val precioConIVA: Double
    val porcentajeIVA = when (tipoIVA) {
        "general" -> iva.general+1
        "reduït"  -> iva.reduit+1
        "superreduït" -> iva.superReduit+1
        "exempt" -> iva.exempt+1
        else -> 0.0
    }
    precioConIVA = precio * porcentajeIVA
    return precioConIVA
}

/**
 * Función que incia el scanner para recibir valores
 * @return devuelve un scanner
 */
fun abrirScaner(): Scanner{
    val scan = Scanner(System.`in`)
    return scan
}

/**
 * Función que cierra un scanner abierto
 * @param scan recibe el scanner a cerrar
 * @return no devuelve nada
 */
fun cerrarScaner(scan: Scanner){
    scan.close()
}

/**
 * Función que imprime el precio total formateado como 0.00
 * @param precioConIVA recibe el precio total
 * @return no devuelve nada
 */
fun imprimiResutado(precioConIVA: Double){
    println("El precio con IVA incluido és ${String.format(Locale.UK, "%.2f", precioConIVA)}")
}

/**
 * Pide el precio inicial
 * @return devuelve el precio
 */
fun pedirPrecio(msg: String, scan: Scanner): Double{
    var precio: Double
    print(msg)
    precio = scan.nextDouble()
    return precio
}


/**
 * Pide el tipo de iva
 * @return devuelve el tipo de iva
 */
fun pedirTipoIVA(msg: String, scan: Scanner): String{
    var precio: String
    print(msg)
    precio = scan.next().lowercase()
    return precio
}

/**
 * Pide la fecha
 * @return devuelve la fecha
 */
fun pedirFecha(msg: String, scan: Scanner): String{
    var fecha: String
    print(msg)
    fecha = scan.next()
    return fecha
}
