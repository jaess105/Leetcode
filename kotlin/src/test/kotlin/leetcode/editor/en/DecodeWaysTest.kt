package leetcode.editor.en

import DecodeWays
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DecodeWaysTest {
    @Test
    fun test1() {
        val input = "12"
        val expected = 2
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val input = "226"
        val expected = 3
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `test case 3`() {
        val input = "06"
        val expected = 0
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `test case last is 0`() {
        val input = "10"
        val expected = 1
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `correct handling of zero`() {
        val input = "2101"
        val expected = 1
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `test longer sequence`() {
        val input = "1123"
        val expected = 5
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `test for input with more than 1 and 2`() {
        val input = "123123"
        val expected = 9
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `invalid 00`() {
        val input = "10011"
        val expected = 0
        val unit = DecodeWays.Solution()

        val actual = unit.numDecodings(input)

        assertEquals(expected, actual)
    }
}