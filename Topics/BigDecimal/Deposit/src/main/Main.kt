import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val startingAmount = BigDecimal(readLine())
    val yearlyPercent = BigDecimal(readLine())
    val years = readLine()!!.toInt()
    var finalAmount = startingAmount
    finalAmount *= ((BigDecimal.ONE + yearlyPercent.setScale(2) / BigDecimal("100")).pow(years))
    println("Amount of money in the account: ${finalAmount.setScale(2, RoundingMode.CEILING)}")
}