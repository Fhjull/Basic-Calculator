import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    val number = readLine()
    val newScale = readLine()!!.toInt()
    val a = BigDecimal(number).setScale(newScale, RoundingMode.HALF_DOWN)
    println(a)

}