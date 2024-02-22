package leetcode.editor.en

import PerfectSquares
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PerfectSquaresTest {
    companion object {
        @JvmStatic
        fun testInput(): List<Arguments> = listOf(
            Arguments { arrayOf(12, 3) },
            Arguments { arrayOf(13, 2) },
        )
    }

    @ParameterizedTest(name = "Case {index}: The least number of perfect squares of {0} is {1}!")
    @MethodSource("testInput")
    fun testParameterized(input: Int, expected: Int) {
        val unit = PerfectSquares.Solution()

        val actual = unit.numSquares(input)

        assertEquals(expected, actual)
    }
}