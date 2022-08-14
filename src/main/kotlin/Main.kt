package ru.netelogy

fun main() {
    val cardType = CardsTypes.MASTERCARD
    val beforeTransactionMonth = 75000.0
    val transactionSumm = 10000.0

    print("Комиссия составит ${commissionCalc(cardType, beforeTransactionMonth, transactionSumm)} копеек.")
}

enum class CardsTypes {
    VISA, MIR, MASTERCARD, MAESTRO, VKPAY
}

fun commissionCalc(
    type: CardsTypes = CardsTypes.VKPAY,
    beforeTransactionMonth: Double = 0.0,
    transaction: Double
): Double {
    return when (type) {
        CardsTypes.MASTERCARD, CardsTypes.MAESTRO ->
            if (beforeTransactionMonth < 75000) {
                return 0.0
            } else {
                if (transaction * 0.006 < 20) {
                    return 20.0 * 100.0
                } else {
                    return transaction * 0.006 * 100.0
                }
            }
        CardsTypes.VISA, CardsTypes.MIR ->
            if (transaction * 0.0075 < 35) {
                return 35.0 * 100.0
            } else {
                return transaction * 0.0075 * 100.0
            }
        CardsTypes.VKPAY -> 0.0
    }
}
