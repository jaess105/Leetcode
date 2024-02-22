package leetcode.editor.en

import UglyNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UglyNumberTest {
    companion object {
        @JvmStatic
        fun testInput(): List<Arguments> = listOf(
            Arguments { arrayOf(6, true) },
            Arguments { arrayOf(1, true) },
            Arguments { arrayOf(14, false) },
            Arguments { arrayOf(-2147483648, false) }
        )
    }

    @ParameterizedTest(name = "Case {index}: {0} is ugly should be {1}")
    @MethodSource("testInput")
    fun testParameterized(input: Int, expected: Boolean) {
        val unit = UglyNumber.Solution()

        val actual = unit.isUgly(input)

        assertEquals(expected, actual)
    }
}