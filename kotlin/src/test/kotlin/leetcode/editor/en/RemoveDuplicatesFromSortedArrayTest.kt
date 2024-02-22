package leetcode.editor.en

import RemoveDuplicatesFromSortedArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RemoveDuplicatesFromSortedArrayTest {
    fun test(nums: IntArray, expectedNums: IntArray) {
        val k = RemoveDuplicatesFromSortedArray.Solution()
            .removeDuplicates(nums); // Calls your implementation

        assertEquals(k, expectedNums.size)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }
    }

    @Test
    fun testCase1() {
        val nums = intArrayOf(1, 1, 2)
        val expectedNums = intArrayOf(1, 2)

        test(nums, expectedNums)
    }

    @Test
    fun testCase2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val expectedNums = intArrayOf(0, 1, 2, 3, 4)

        test(nums, expectedNums)
    }

    @Test
    fun testCase3() {
        val nums = intArrayOf(
            0,
            0,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
        )
        val expectedNums = intArrayOf(0, 1)

        test(nums, expectedNums)
    }
}