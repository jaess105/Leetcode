package leetcode.editor.en

import WordSearch
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordSearchTest {
    // \[([^[\[\]]]+)\]
    companion object {
        @JvmStatic
        fun testInput(): List<Arguments> = listOf(
            Arguments {
                arrayOf(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "ABCCED",
                    true
                )
            },
            Arguments {
                arrayOf(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "SEE",
                    true
                )
            },
            Arguments {
                arrayOf(
                    arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                    ),
                    "ABCB",
                    false
                )
            }
        )
    }

    @ParameterizedTest(name = "Case {index}: {1} is contained is {2}!")
    @MethodSource("testInput")
    fun testParameterized(input: Array<CharArray>, word: String, expected: Boolean) {
        val unit = WordSearch.Solution()

        val actual = unit.exist(input, word)

        assertEquals(expected, actual)
    }
}