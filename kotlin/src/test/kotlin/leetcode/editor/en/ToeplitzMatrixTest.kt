package leetcode.editor.en

import ToeplitzMatrix
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ToeplitzMatrixTest {
    @Test
    fun `Case 1`() {
        val input = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 1, 2, 3),
            intArrayOf(9, 5, 1, 2)
        )
        val expected = true
        val unit = ToeplitzMatrix.Solution()

        val actual = unit.isToeplitzMatrix(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `Case 2`() {
        val input = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 2),
        )
        val expected = false
        val unit = ToeplitzMatrix.Solution()

        val actual = unit.isToeplitzMatrix(input)

        assertEquals(expected, actual)
    }
}