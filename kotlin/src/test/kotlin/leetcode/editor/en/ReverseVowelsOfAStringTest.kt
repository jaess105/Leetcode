package leetcode.editor.en

import ReverseVowelsOfAString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReverseVowelsOfAStringTest {
    @Test
    fun `Case 1`() {
        val input = "hello"
        val expected = "holle"
        val unit = ReverseVowelsOfAString.Solution()

        val actual = unit.reverseVowels(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `Case 2`() {
        val input = "leetcode"
        val expected = "leotcede"
        val unit = ReverseVowelsOfAString.Solution()

        val actual = unit.reverseVowels(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `Test 290`() {
        val input = "aA"
        val expected = "Aa"
        val unit = ReverseVowelsOfAString.Solution()

        val actual = unit.reverseVowels(input)

        assertEquals(expected, actual)
    }
}