package leetcode.editor.en

import OrderlyQueue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OrderlyQueueTest {
    @Test
    fun `Case 1`() {
        val s = "cba"
        val k = 1
        val expected = "acb"
        val unit = OrderlyQueue.Solution()

        val actual = unit.orderlyQueue(s, k)

        assertEquals(expected, actual)
    }

    @Test
    fun `Case 2`() {
        val s = "baaca"
        val k = 3
        val expected = "aaabc"
        val unit = OrderlyQueue.Solution()

        val actual = unit.orderlyQueue(s, k)

        assertEquals(expected, actual)
    }
}