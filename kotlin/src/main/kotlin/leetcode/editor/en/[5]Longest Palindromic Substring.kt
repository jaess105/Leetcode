import kotlin.math.min
import kotlin.math.max

//Given a string s, return the longest palindromic substring in s.
//
// A string is called a palindrome string if the reverse of that string is the 
//same as the original string. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 22143 👎 1272


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): String {
        return bruteForce(s)
    }


    private fun bruteForce(s: String): String {
        val palindroms = mutableListOf<IntArray>()
        for (i1 in s.indices) {
            for (i2 in s.indices.reversed()) {
                var tmpI1 = i1
                var tmpI2 = i2
                while (tmpI1 <= tmpI2
                    && tmpI1 < s.length
                    && tmpI2 >= 0
                    && s[tmpI1] == s[tmpI2]
                ) {
                    tmpI1++
                    tmpI2--
                }
                if (tmpI1 > tmpI2
                    && i1 <= i2
                ) {
                    val palindromeCandidate = s.substring(i1, i2 + 1)
                    if (isPalindrome(palindromeCandidate)) {
                        if (palindromeCandidate.length == s.length) {
                            return palindromeCandidate;
                        }
                        palindroms.add(intArrayOf(i1, i2))
                    }
                }
            }
        }
        return palindroms.maxBy { it[1] - it[0] }.let { s.substring(it!![0]!!, it!![1]!! + 1) }!!
    }

    private fun isPalindrome(str: String): Boolean {
        for ((c1, c2) in str.zip(str.reversed())) {
            if (c1 != c2) {
                return false
            }
        }
        return true
    }
}


//leetcode submit region end(Prohibit modification and deletion)
