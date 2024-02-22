//Given an m x n board of characters and a list of strings words, return all 
//words on the board. 
//
// Each word must be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once in a word. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i",
//"f","l","v"]], words = ["oath","pea","eat","rain"]
//Output: ["eat","oath"]
// 
//
// Example 2: 
// 
// 
//Input: board = [["a","b"],["c","d"]], words = ["abcb"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] is a lowercase English letter. 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] consists of lowercase English letters. 
// All the strings of words are unique. 
// 
//
// Related Topics Array String Backtracking Trie Matrix 👍 7451 👎 327

class WordSearch2 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class PrefixTree(
        val root: TrieNode = TrieNode()
    ) {
        constructor(words: Array<String>) : this() {
            this.addWords(words)
        }

        class TrieNode(
            var endOfWord: Boolean = false,
            val children: MutableMap<Char, TrieNode> = mutableMapOf()
        ) {
            fun hasChild(char: Char): Boolean = children.containsKey(char)
        }


        fun addWord(word: String) {
            var currNode = root
            for (char in word) {
                var next = currNode.children[char]
                if (next == null) {
                    next = TrieNode()
                    currNode.children[char] = next
                }
                currNode = next
            }
            currNode.endOfWord = true
        }

        fun addWords(words: Array<String>) {
            for (word in words) {
                this.addWord(word)
            }
        }

    }

    class Solution {
        private val visited = mutableSetOf<Pair<Int, Int>>()

        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            val foundWords = mutableSetOf<String>()
            for (i in board.indices) {
                for (j in board[i].indices) {
                    for (word in words) {
                        if (word.first() == board[i][j]
                            && containsWord(board, word.drop(1), i, j)
                        ) {
                            foundWords.add(word)
                        }
                        if (word.last() == board[i][j]
                            && containsWord(board, word.reversed().drop(1), i, j)
                        ) {
                            foundWords.add(word)
                        }
                    }
                }
            }
            return foundWords.toList()
        }

        private fun containsWord(
            board: Array<CharArray>,
            word: String,
            startI: Int,
            startJ: Int
        ): Boolean {
            val point = Pair(startI, startJ)
            if (visited.contains(point)) {
                return false
            } else if (word.isEmpty()) {
                return true
            }
            visited.add(point)


            var ret = false
            if (startI < board.size - 1 && board[startI + 1][startJ] == word.first()) {
                ret = ret || containsWord(board, word.drop(1), startI + 1, startJ)
            }
            if (startJ < board[0].size - 1 && board[startI][startJ + 1] == word.first()) {
                ret = ret || containsWord(board, word.drop(1), startI, startJ + 1)
            }
            if (startI > 0 && board[startI - 1][startJ] == word.first()) {
                ret = ret || containsWord(board, word.drop(1), startI - 1, startJ)
            }
            if (startJ > 0 && board[startI][startJ - 1] == word.first()) {
                ret = ret || containsWord(board, word.drop(1), startI, startJ - 1)
            }
            visited.remove(point)
            return ret
        }
    }

//    class Solution {
//        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
//            val trie = PrefixTree(words)
//            val foundWords = mutableSetOf<String>()
//            val visited = mutableSetOf<Pair<Int, Int>>()
//
//            fun dfs(rowAndCol: Pair<Int, Int>, node: PrefixTree.TrieNode, word: String) {
//                if (rowAndCol.first < 0 || rowAndCol.second < 0
//                    || rowAndCol.first == board.size
//                    || rowAndCol.second == board[0].size
//                    || visited.contains(rowAndCol)
//                    || !node.hasChild(board[rowAndCol.first][rowAndCol.second])
//                ) {
//                    return
//                }
//                visited.add(rowAndCol)
//                val currChar = board[rowAndCol.first][rowAndCol.second]
//                val nextNode = node.children[currChar]!!
//                val nextWord = word + currChar
//                if (nextNode.endOfWord) {
//                    foundWords.add(nextWord)
//                }
//
//                dfs(Pair(rowAndCol.first + 1, rowAndCol.second), nextNode, nextWord)
//                dfs(Pair(rowAndCol.first - 1, rowAndCol.second), nextNode, nextWord)
//                dfs(Pair(rowAndCol.first, rowAndCol.second + 1), nextNode, nextWord)
//                dfs(Pair(rowAndCol.first, rowAndCol.second - 1), nextNode, nextWord)
//
//                visited.remove(rowAndCol)
//            }
//
//
//            for (i in board.indices) {
//                for (j in board[i].indices) {
//                    val rowAndCol = Pair(i, j)
//                    dfs(rowAndCol, trie.root, "")
//                }
//            }
//            return foundWords.toList()
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)
}