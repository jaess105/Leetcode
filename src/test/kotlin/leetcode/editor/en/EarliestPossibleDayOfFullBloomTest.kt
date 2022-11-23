package leetcode.editor.en

import EarliestPossibleDayOfFullBloom
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EarliestPossibleDayOfFullBloomTest {
    @Test
    fun `Case 1`() {
        val input = mapOf(
            "plantTime" to intArrayOf(1, 4, 3),
            "growTime" to intArrayOf(2, 3, 1)
        )
        val expected = 9
        val unit = EarliestPossibleDayOfFullBloom.Solution()

        val actual = unit.earliestFullBloom(input["plantTime"]!!, input["growTime"]!!)

        assertEquals(expected, actual)
    }
}