import kotlin.math.sqrt

//An ugly number is a positive integer whose prime factors are limited to 2, 3,
//and 5. 
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics Math 👍 2146 👎 1305

class UglyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isUgly(n: Int): Boolean {
            if (n <= 0) {
                return false
            }
            var nMut = n
            while (nMut % 2 == 0) {
                nMut /= 2
            }
            while (nMut % 3 == 0) {
                nMut /= 3
            }
            while (nMut % 5 == 0) {
                nMut /= 5
            }
            return nMut == 1
        }
    }

    fun isPrime(n: Int): Boolean {
        if (n <= 1) return false else if (n == 2) return true else if (n % 2 == 0) return false

        // If not, then just check the odds
        var i = 3
        while (i <= sqrt(n.toDouble())) {
            if (n % i == 0) return false
            i += 2
        }
        return true
    }

    //leetcode submit region end(Prohibit modification and deletion)
}