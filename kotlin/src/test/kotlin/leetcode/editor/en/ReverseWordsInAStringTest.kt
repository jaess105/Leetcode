package leetcode.editor.en

import ReverseWordsInAString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseWordsInAStringTest {

    companion object {
        @JvmStatic
        fun testInput(): List<Arguments> = listOf(
            Arguments { arrayOf("the sky is blue", "blue is sky the") },
            Arguments { arrayOf("  hello world  ", "world hello") },
            Arguments { arrayOf("a good   example", "example good a") },
        )
    }

    @ParameterizedTest(name = "Case {index}: Reverse \"{0}\" to \"{1}\"")
    @MethodSource("testInput")
    fun testParameterized(input: String, expected: String) {
        val unit = ReverseWordsInAString.Solution()

        val actual = unit.reverseWords(input)

        assertEquals(expected, actual)
    }

}