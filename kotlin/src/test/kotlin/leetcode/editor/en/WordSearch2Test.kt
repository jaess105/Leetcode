package leetcode.editor.en

import WordSearch2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordSearch2Test {
    @Test
    fun `Case 1`() {
        val board = arrayOf(
            charArrayOf('o', 'a', 'a', 'n'),
            charArrayOf('e', 't', 'a', 'e'),
            charArrayOf('i', 'h', 'k', 'r'),
            charArrayOf('i', 'f', 'l', 'v')
        )
        val words = arrayOf("oath", "pea", "eat", "rain")
        val expected = listOf("eat", "oath")
        val unit = WordSearch2.Solution()

        val actual = unit.findWords(board, words)

        assertThat(expected).hasSameElementsAs(actual)
    }

    @Test
    fun `Case 2`() {
        val board = arrayOf(charArrayOf('a', 'b'), charArrayOf('c', 'd'))
        val words = arrayOf("abcb")
        val expected = listOf<String>()
        val unit = WordSearch2.Solution()

        val actual = unit.findWords(board, words)

        assertThat(expected).hasSameElementsAs(actual)
    }


    @Test
    fun `TestCase 24`() {
        val board = arrayOf(charArrayOf('a', 'a'))
        val words = arrayOf("aa")
        val expected = listOf<String>("aa")
        val unit = WordSearch2.Solution()

        val actual = unit.findWords(board, words)

        assertThat(expected).hasSameElementsAs(actual)
    }

    @Test
    fun `TestCase 30`() {
        val board = arrayOf(
            charArrayOf('a', 'b', 'c', 'e'),
            charArrayOf('x', 'x', 'c', 'd'),
            charArrayOf('x', 'x', 'b', 'a')
        )
        val words = arrayOf("abc", "abcd")
        val expected = listOf<String>("abc", "abcd")
        val unit = WordSearch2.Solution()

        val actual = unit.findWords(board, words)

        assertThat(expected).hasSameElementsAs(actual)
    }

    @Test
    fun `TestCase 59`() {
        val board = arrayOf(
            charArrayOf('b', 'd', 'a', 'a', 'c', 'c', 'b', 'e'),
            charArrayOf('d', 'c', 'e', 'b', 'b', 'e', 'e', 'b'),
            charArrayOf('b', 'd', 'b', 'e', 'b', 'a', 'a', 'e'),
            charArrayOf('b', 'c', 'd', 'a', 'd', 'd', 'a', 'c'),
            charArrayOf('e', 'd', 'b', 'c', 'a', 'd', 'a', 'c'),
            charArrayOf('e', 'b', 'a', 'a', 'c', 'd', 'c', 'd'),
            charArrayOf('d', 'e', 'c', 'c', 'b', 'd', 'd', 'c'),
            charArrayOf('c', 'a', 'c', 'e', 'c', 'b', 'd', 'c'),
            charArrayOf('a', 'e', 'd', 'b', 'c', 'b', 'a', 'a'),
            charArrayOf('e', 'a', 'a', 'a', 'a', 'c', 'c', 'b'),
            charArrayOf('d', 'e', 'e', 'e', 'c', 'b', 'c', 'e')
        )
        val words = arrayOf("cbcccec")
        val expected = listOf<String>("cbcccec")
        val unit = WordSearch2.Solution()

        val actual = unit.findWords(board, words)

        assertThat(expected).hasSameElementsAs(actual)
    }
}