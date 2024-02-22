package leetcode.editor.en

import MinimumGeneticMutation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinimumGeneticMutationTest {
    @Test
    fun `Example 1`() {
        val start = "AACCGGTT"
        val end = "AACCGGTA"
        val bank = arrayOf("AACCGGTA")
        val expected = 1
        val unit = MinimumGeneticMutation.Solution()

        val actual = unit.minMutation(start, end, bank)

        assertEquals(expected, actual)
    }

    @Test
    fun `Example 2`() {
        val start = "AACCGGTT"
        val end = "AAACGGTA"
        val bank = arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA")
        val expected = 2
        val unit = MinimumGeneticMutation.Solution()

        val actual = unit.minMutation(start, end, bank)

        assertEquals(expected, actual)
    }

    @Test
    fun `Example 3`() {
        val start = "AAAAACCC"
        val end = "AACCCCCC"
        val bank = arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC")
        val expected = 3
        val unit = MinimumGeneticMutation.Solution()

        val actual = unit.minMutation(start, end, bank)

        assertEquals(expected, actual)
    }

    @Test
    fun `Test Case 11`() {
        val start = "AACCTTGG"
        val end = "AATTCCGG"
        val bank = arrayOf("AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC")
        val expected = -1
        val unit = MinimumGeneticMutation.Solution()

        val actual = unit.minMutation(start, end, bank)

        assertEquals(expected, actual)
    }
}