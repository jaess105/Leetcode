import java.lang.StringBuilder

//Write a function to find the longest common prefix string amongst an array of
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String 👍 10878 👎 3465

class LongestCommonPrefix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) {
                return ""
            }
            val prefix = StringBuilder()
            var i = 0
            while (strs[0].length > i) {
                val currentChar = strs[0][i]
                for (str in strs) {
                    if (str.length - 1 < i || str[i] != currentChar) {
                        return prefix.toString()
                    }
                }
                prefix.append(currentChar)
                i++
            }
            return prefix.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}