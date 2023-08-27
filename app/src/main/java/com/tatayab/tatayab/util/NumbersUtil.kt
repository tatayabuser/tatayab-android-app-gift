package com.tatayab.tatayab.util

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.temporal.TemporalAmount
import java.util.*
import kotlin.math.roundToInt

object NumbersUtil {

    @JvmStatic
    fun calculateOffPercent(price: Float, basePrice: Float): Int {
        val discount = basePrice - price;
        val offPercentage = (discount / basePrice) * 100
        return offPercentage.roundToInt()
    }

    @JvmStatic
    fun hasPriceOff(price: Float, basePrice: Float): Boolean =
        ((price != basePrice) && (basePrice > price))

    @JvmStatic
    fun isInStock(actions: String?, amount: Int?, minAmount: Int?): Boolean {
        if (amount != null) {
            return when (actions) {
                "B" -> {
                    true
                }
                else -> {
                    if (amount <= 0)
                        false
                    else
                        amount >= minAmount!!
                }
            }
        } else
            return false
    }

    @JvmStatic
    fun maxAmount(maxQty: Int, amount: Int): Int {
        return if (maxQty > amount) amount else maxQty
    }

    @JvmStatic
    fun minQuantity(minQty: Int): Int {
        return if (minQty > 0) minQty else 1
    }


    @JvmStatic
    fun formatNumber(number: Float): String? {
        val df = DecimalFormat("#.###", DecimalFormatSymbols.getInstance(Locale.US))
        df.roundingMode = RoundingMode.CEILING
        return df.format(number)
    }

    @JvmStatic
    fun formatNumber(number: Float, decimal: Int): String? {
        return "%.${decimal}f".format(Locale.US, number)
    }

    @JvmStatic
    fun formatNumberString(number: Int, decimal: Int): String? {
        return "%${decimal}d".format(Locale.US, number)
    }

    @JvmStatic
    fun formatNumberDigit(number: Int, decimal: Int): Int {
        return "%${decimal}d".format(Locale.US, number).toInt()
    }
}