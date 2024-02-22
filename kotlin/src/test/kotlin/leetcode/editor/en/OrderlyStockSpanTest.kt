package leetcode.editor.en

import OrderlyStockSpan.StockSpanner
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class OrderlyStockSpanTest {
    @Test
    fun `Case 1`() {
        val expected = mutableListOf(1, 1, 1, 2, 1, 4, 6)
        val stockSpanner = StockSpanner()
        val actual = mutableListOf<Int>()

        actual.add(stockSpanner.next(100)) // return 1
        actual.add(stockSpanner.next(80)) // return 1
        actual.add(stockSpanner.next(60)) // return 1
        actual.add(stockSpanner.next(70)) // return 2
        actual.add(stockSpanner.next(60)) // return 1
        actual.add(stockSpanner.next(75)) // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        actual.add(stockSpanner.next(85)) // return 6


        assertEquals(expected, actual)
    }
}