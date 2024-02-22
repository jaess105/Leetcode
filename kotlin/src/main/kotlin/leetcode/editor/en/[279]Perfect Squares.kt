import java.util.LinkedList
import kotlin.math.min
import kotlin.math.pow

//Given an integer n, return the least number of perfect square numbers that
//sum to n. 
//
// A perfect square is an integer that is the square of an integer; in other 
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics Math Dynamic Programming Breadth-First Search 👍 8173 👎 355

class PerfectSquares {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numSquares(n: Int): Int {
            val squares = sortedSetOf<Int>()
            val intMax = Int.MAX_VALUE.toLong()
            val sol = Array(n + 1) { intMax }
            for (i in 1..n) {
                val iSq = i.toDouble().pow(2.0).toInt()
                if (iSq <= n) {
                    squares.add(iSq)
                    sol[iSq] = 1
                }

                for (sq in squares) {
                    if (i < sq) {
                        break
                    }
                    sol[i] = min(sol[i], 1 + sol[i - sq])
                }
            }
            return sol[n].toInt()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

