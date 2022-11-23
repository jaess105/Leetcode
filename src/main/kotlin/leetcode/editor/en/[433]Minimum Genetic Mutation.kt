//A gene string can be represented by an 8-character long string, with choices 
//from 'A', 'C', 'G', and 'T'. 
//
// Suppose we need to investigate a mutation from a gene string start to a gene 
//string end where one mutation is defined as one single character changed in the 
//gene string. 
//
// 
// For example, "AACCGGTT" --> "AACCGGTA" is one mutation. 
// 
//
// There is also a gene bank bank that records all the valid gene mutations. A 
//gene must be in bank to make it a valid gene string. 
//
// Given the two gene strings start and end and the gene bank bank, return the 
//minimum number of mutations needed to mutate from start to end. If there is no 
//such a mutation, return -1. 
//
// Note that the starting point is assumed to be valid, so it might not be 
//included in the bank. 
//
// 
// Example 1: 
//
// 
//Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. 
//
// 
//
// Related Topics Hash Table String Breadth-First Search 👍 1616 👎 166


class MinimumGeneticMutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minMutation(start: String, end: String, bank: Array<String>): Int {
            if (start == end) return 0
            if (!bank.contains(end)) return -1


            val minDistanceOrNull =
                bank.filter { hammingDistance(it, start) == 1 }
                    .map { minMutation(it, end, bank.filter { x -> x != it }.toTypedArray()) }
                    .filter { it != -1 }
                    .min()

            return if (minDistanceOrNull != null) minDistanceOrNull + 1 else -1
        }

        private fun hammingDistance(a: String, b: String): Int =
            a.zip(b).fold(0) { initial, (x, y) ->
                initial + (if (x == y) 0 else 1)
            }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
