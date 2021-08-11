import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val a = BigDecimal(readLine())
    val b = BigDecimal(readLine())
    val c = BigDecimal(readLine())
    val d = (a + b + c) / BigDecimal("3")
    println(d.setScale(0, RoundingMode.DOWN))
}