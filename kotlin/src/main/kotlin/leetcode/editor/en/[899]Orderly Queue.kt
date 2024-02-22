//You are given a string s and an integer k. You can choose one of the first k 
//letters of s and append it at the end of the string.. 
//
// Return the lexicographically smallest string you could have after applying 
//the mentioned step any number of moves. 
//
// 
// Example 1: 
//
// 
//Input: s = "cba", k = 1
//Output: "acb"
//Explanation: 
//In the first move, we move the 1ˢᵗ character 'c' to the end, obtaining the 
//string "bac".
//In the second move, we move the 1ˢᵗ character 'b' to the end, obtaining the 
//final result "acb".
// 
//
// Example 2: 
//
// 
//Input: s = "baaca", k = 3
//Output: "aaabc"
//Explanation: 
//In the first move, we move the 1ˢᵗ character 'b' to the end, obtaining the 
//string "aacab".
//In the second move, we move the 3ʳᵈ character 'c' to the end, obtaining the 
//final result "aaabc".
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= s.length <= 1000 
// s consist of lowercase English letters. 
// 
//
// Related Topics Math String Sorting 👍 909 👎 462

class OrderlyQueue {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun orderlyQueue(s: String, k: Int): String {
            return if (k > 1) {
                s.toCharArray().sorted().joinToString(separator = "")
            } else {
                var best = s
                var last = s
                for (i in s.indices) {
                    last += last.first()
                    last = last.drop(1)
                    if (last < best) {
                        best = last
                    }
                }
                best
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}