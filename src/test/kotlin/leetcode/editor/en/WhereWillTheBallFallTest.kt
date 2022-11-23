package leetcode.editor.en

import WhereWillTheBallFall
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class WhereWillTheBallFallTest {
    @Test
    fun `case 1`() {
        val input = arrayOf(
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(-1, -1, -1, 1, 1),
            intArrayOf(1, 1, 1, 1, -1),
            intArrayOf(-1, -1, -1, -1, -1)
        )
        val expected = intArrayOf(1, -1, -1, -1, -1)
        val unit = WhereWillTheBallFall.Solution()

        val actual = unit.findBall(input)

        assertContentEquals(expected, actual)
    }

    @Test
    fun `case 2`() {
        val input = arrayOf(
            intArrayOf(-1)
        )
        val expected = intArrayOf(-1)
        val unit = WhereWillTheBallFall.Solution()

        val actual = unit.findBall(input)

        assertContentEquals(expected, actual)
    }

    @Test
    fun `case 3`() {
        val input = arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1)
        )
        val expected = intArrayOf(0, 1, 2, 3, 4, -1)
        val unit = WhereWillTheBallFall.Solution()

        val actual = unit.findBall(input)

        assertContentEquals(expected, actual)
    }

}