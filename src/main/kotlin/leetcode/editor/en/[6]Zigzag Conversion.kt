import kotlin.math.min

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 4510 👎 9931

class ZigZagConversion {
    //leetcode submit region begin(Prohibit modification and deletion) import kotlin.math.min

    class Solution {
        fun convert(s: String, numRows: Int): String {
            if (numRows == 1) return s

            val rows: MutableList<StringBuilder> = mutableListOf()
            for (i in 0 until min(numRows, s.length)) rows.add(StringBuilder())

            var curRow = 0
            var goingDown = false

            for (c in s.toCharArray()) {
                rows[curRow].append(c)
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
                curRow += if (goingDown) 1 else -1
            }

            val ret = StringBuilder()
            for (row in rows) ret.append(row)
            return ret.toString()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}