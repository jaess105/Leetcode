#include <stdio.h>
#include <assert.h>

#include <string.h>
#include <stdlib.h>
// Function to return gcd of a and b
int gcd(int a, int b)
{
    // Find Minimum of a and b
    int result = ((a < b) ? a : b);
    while (result > 0)
    {
        // Check if both a and b are divisible by result
        if (a % result == 0 && b % result == 0)
        {
            break;
        }
        result--;
    }
    // return gcd of a nd b
    return result;
}

/// For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
/// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
char *gcdOfStrings(char *str1, char *str2)
{
    size_t str1Len = strlen(str1), str2Len = strlen(str2);

    int gcdStrLen = gcd(str1Len, str2Len);
    for (size_t i = 0; i < str1Len || i < str2Len; i++)
    {
        if ((str1[i % str1Len] != str2[i % str2Len]) || (str1[i % str1Len] != str1[i % gcdStrLen]))
        {
            char *empty = malloc(sizeof(char));
            empty[0] = '\0';
            return empty;
        }
    }

    char *gcdStr = malloc((gcdStrLen + 1) * sizeof(char));
    strncpy(gcdStr, str1, gcdStrLen);
    gcdStr[gcdStrLen] = '\0';

    return gcdStr;
}

void example1();
void example2();
void example3();
void example4();
void example5();

int main(int argc, char const *argv[])
{
    example1();
    example2();
    example3();
    example4();
    return 0;
}

// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
void example1()
{
    char *word1 = "ABCABC";
    char *word2 = "ABC";
    char *expected = "ABC";

    char *res = gcdOfStrings(word1, word2);

    printf("%s\n", res);

    assert(strcmp(res, expected) == 0);

    free(res);
}

// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"

void example2()
{
    char *word1 = "ABABAB";
    char *word2 = "ABAB";
    char *expected = "AB";

    char *res = gcdOfStrings(word1, word2);

    printf("%s\n", res);

    assert(strcmp(res, expected) == 0);

    free(res);
}

// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""
void example3()
{
    char *word1 = "LEET";
    char *word2 = "CODE";
    char *expected = "";

    char *res = gcdOfStrings(word1, word2);

    printf("%s\n", res);

    assert(strcmp(res, expected) == 0);

    free(res);
}

// Constraints:

//     1 <= str1.length, str2.length <= 1000
//     str1 and str2 consist of English uppercase letters.

void example4()
{
    char *word1 = "ABCDEF";
    char *word2 = "ABC";
    char *expected = "";

    char *res = gcdOfStrings(word1, word2);

    printf("%s\n", res);

    assert(strcmp(res, expected) == 0);

    free(res);
}

void example5()
{
    char *word1 = "AABBAABBAA";
    char *word2 = "AABB";
    char *expected = "";

    char *res = gcdOfStrings(word1, word2);

    printf("%s\n", res);

    assert(strcmp(res, expected) == 0);

    free(res);
}