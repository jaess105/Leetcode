//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//lower and upper cases, more than once. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// 
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 2864 👎 2271

val vowels = setOf(
    'a', 'e', 'i', 'o', 'u',
    'A', 'E', 'I', 'O', 'U'
)

fun Char.isVowel(): Boolean = vowels.contains(this)

class ReverseVowelsOfAString {
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        fun reverseVowels(s: String): String {
            val arr = s.toCharArray()
            var left = 0
            var right = s.length - 1
            while (left < right) {
                while (left < right && !arr[left].isVowel()) left++
                while (right > left && !arr[right].isVowel()) right--
                var temp = arr[left]
                arr[left++] = arr[right]
                arr[right--] = temp
            }
            return String(arr)
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
}

