package leetcode.editor.en

import Solution
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    val sol = Solution()

    @Test
    fun test1() {
        val input = "babad"
        val result = sol.longestPalindrome(input)
        assertEquals("bab", result)
    }

    @Test
    fun test2() {
        val input = "cbbd"
        val result = sol.longestPalindrome(input)
        assertEquals("bb", result)
    }
}