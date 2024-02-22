package leetcode.editor.en

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ZigZagConversionTest {
    @Test
    fun test1() {
        val s = "PAYPALISHIRING"
        val numRows = 4
        val expected = "PINALSIGYAHRPI"

        val sol = ZigZagConversion.Solution()
        val actual = sol.convert(s, numRows)

        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val s = "PAYPALISHIRING"
        val numRows = 3
        val expected = "PAHNAPLSIIGYIR"

        val sol = ZigZagConversion.Solution()
        val actual = sol.convert(s, numRows)

        assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val s = "A"
        val numRows = 1
        val expected = "A"

        val sol = ZigZagConversion.Solution()
        val actual = sol.convert(s, numRows)

        assertEquals(expected, actual)
    }
}