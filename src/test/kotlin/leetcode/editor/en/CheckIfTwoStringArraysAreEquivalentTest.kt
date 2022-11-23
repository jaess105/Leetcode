package leetcode.editor.en

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckIfTwoStringArraysAreEquivalentTest {
    @Test
    fun `case 1`() {
        val word1 = arrayOf("ab", "c")
        val word2 = arrayOf("a", "bc")
        val expected = true
        val unit = CheckIfTwoStringArraysAreEquivalent.Solution()

        val actual = unit.arrayStringsAreEqual(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `case 2`() {
        val word1 = arrayOf("a", "cb")
        val word2 = arrayOf("ab", "c")
        val expected = false
        val unit = CheckIfTwoStringArraysAreEquivalent.Solution()

        val actual = unit.arrayStringsAreEqual(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `case 3`() {
        val word1 = arrayOf("abc", "d", "defg")
        val word2 = arrayOf("abcddefg")
        val expected = true
        val unit = CheckIfTwoStringArraysAreEquivalent.Solution()

        val actual = unit.arrayStringsAreEqual(word1, word2)

        assertEquals(expected, actual)
    }
}