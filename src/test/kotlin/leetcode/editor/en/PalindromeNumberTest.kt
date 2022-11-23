package leetcode.editor.en

import PalindromeNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PalindromeNumberTest {
    @Test
    fun test1() {
        val input = 121
        val sol = PalindromeNumber.Solution()
        val actual = sol.isPalindrome(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val input = 1234567899
        val expected = false

        val sol = PalindromeNumber.Solution()
        val actual = sol.isPalindrome(input)

        assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val input = 10
        val expected = false

        val sol = PalindromeNumber.Solution()
        val actual = sol.isPalindrome(input)

        assertEquals(expected, actual)
    }
}