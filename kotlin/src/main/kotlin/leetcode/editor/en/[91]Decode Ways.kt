import kotlin.math.max

//A message containing letters from A-Z can be encoded into numbers using the
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
//
// Related Topics String Dynamic Programming 👍 9023 👎 4109

class DecodeWays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun numDecodings(s: String): Int {
            if (s.first() == '0') {
                return 0
            }
            if (s.length == 1) {
                return 1
            }

            var curr = 1
            var last = 1

            // Iterating over two numbers simultaneously by starting from 1 to the last index.
            for (i in 1 until s.length) {
                if (s[i] == '0') {
                    // Invalid number as it is either 00 or bigger than 20 with the last digit being a 0.
                    if ((s[i - 1] == '0' || s[i - 1] > '2')) {
                        return 0
                    } else {
                        // It is a 10 or a 20, which means that there is no new branch, but the
                        // last value must be used to account for the 10 or 20.
                        curr = last
                    }
                    // The number could be a double-digit, thereby a new branch is created.
                    // Hereby, the new branches created are as many as there were in the step before.
                } else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] < '7')) {
                    curr += last
                    last = curr - last
                } else {
                    // No double-digit could be build. Thereby no new path was created and the
                    // new last is equal to current.
                    last = curr
                }
            }
            return curr
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}