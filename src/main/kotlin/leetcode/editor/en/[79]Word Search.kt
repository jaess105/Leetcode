//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics Array Backtracking Matrix 👍 11906 👎 483

class WordSearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist(
            board: Array<CharArray>,
            word: String
        ): Boolean {
            for (i in board.indices) {
                for (j in board[i].indices) {
                    if (find(board, word, i, j)) {
                        return true
                    }
                }
            }
            return false
        }

        private fun find(
            board: Array<CharArray>,
            word: String,
            i: Int,
            j: Int,
            visitedCells: MutableSet<Pair<Int, Int>> = mutableSetOf()
        ): Boolean {
            if (word.isEmpty()) {
                return true
            }
            if (i < 0 || i >= board.size ||
                j < 0 || j >= board[i].size ||
                word.first() != board[i][j]
            ) {
                return false
            }
            val pos = Pair(i, j)
            if (visitedCells.contains(pos)) {
                return false
            }
            val newVisitedCells = mutableSetOf(pos)
            newVisitedCells.addAll(visitedCells)
            val wordWithoutFirst = word.substring(1)
            return find(board, wordWithoutFirst, i - 1, j, newVisitedCells) ||
                    find(board, wordWithoutFirst, i, j - 1, newVisitedCells) ||
                    find(board, wordWithoutFirst, i + 1, j, newVisitedCells) ||
                    find(board, wordWithoutFirst, i, j + 1, newVisitedCells)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}