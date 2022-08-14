package ru.netelogy

import org.junit.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun commissionCalcMastercardPercentCommission() {
        val cardType = CardsTypes.MASTERCARD
        val beforeTransactionMonthTotal = 75000.0
        val transactionSumm = 10000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(6000.0, result)
    }

    @Test
    fun commissionCalcMastercardCommission() {
        val cardType = CardsTypes.MASTERCARD
        val beforeTransactionMonthTotal = 75000.0
        val transactionSumm = 1000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(2000.0, result)
    }

    @Test
    fun commissionCalcMastercardNoCommission() {
        val cardType = CardsTypes.MASTERCARD
        val beforeTransactionMonthTotal = 30000.0
        val transactionSumm = 1000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(0.0, result)
    }

    @Test
    fun commissionCalcVKPAY() {
        val cardType = CardsTypes.VKPAY
        val beforeTransactionMonthTotal = 30000.0
        val transactionSumm = 1000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(0.0, result)
    }

    @Test
    fun commissionCalcVISAPercentCommission() {
        val cardType = CardsTypes.VISA
        val beforeTransactionMonthTotal = 30000.0
        val transactionSumm = 100000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(75000.0, result)
    }

    @Test
    fun commissionCalcVISACommission() {
        val cardType = CardsTypes.VISA
        val beforeTransactionMonthTotal = 30000.0
        val transactionSumm = 1000.0

        val result = commissionCalc(cardType, beforeTransactionMonthTotal, transactionSumm)

        assertEquals(3500.0, result)
    }
}