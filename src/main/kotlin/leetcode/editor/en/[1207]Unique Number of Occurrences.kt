//Given an array of integers arr, return true if the number of occurrences of 
//each value in the array is unique, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two 
//values have the same number of occurrences. 
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
//
// Related Topics Array Hash Table 👍 2649 👎 58

class UniqueNumberOfOccurrences {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = mutableMapOf<Int, Int>()
            arr.forEach {
                map.merge(it, 1) { old, _ -> old + 1 }
            }
            val distinctOccurrences = mutableSetOf<Int>()
            map.values.forEach {
                if (!distinctOccurrences.add(it)) {
                    return false
                }
            }
            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}