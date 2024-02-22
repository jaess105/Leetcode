#include <stdio.h>
#include <string.h>
#include <assert.h>

#include <stdlib.h>
#include <stdbool.h>

char *mergeAlternately(char *word1, char *word2)
{
    size_t word1Len = strlen(word1);
    size_t word2Len = strlen(word2);

    size_t resWordLen = word1Len + word2Len;
    char *ret = malloc((resWordLen + 1) * sizeof(char));
    ret[resWordLen] = '\0';

    for (size_t i = 0; i < resWordLen; i++)
    {
        bool word1LongEnough = *word1 != '\0';
        bool word2LongEnough = *word2 != '\0';
        if (word1LongEnough && (i % 2 == 0 || !word2LongEnough))
        {
            ret[i] = *word1;
            word1++;
        }
        else if (word2LongEnough)
        {
            ret[i] = *word2;
            word2++;
        }
    }

    return ret;
}

void example1();
void example2();
void example3();

int main(int argc, char const *argv[])
{
    example3();
    return 0;
}

/// Example 1:
///
/// Input: word1 = "abc", word2 = "pqr"
/// Output: "apbqcr"
/// Explanation: The merged string will be merged as so:
/// word1:  a   b   c
/// word2:    p   q   r
/// merged: a p b q c r

void example1()
{
    char *word1 = "abc";
    char *word2 = "pqr";
    char *expected = "apbqcr";

    int word1Len = 3;
    int word2Len = 3;

    char *res = mergeAlternately(word1, word2);

    for (int i = 0; i < word1Len + word2Len; i++)
    {
        printf("%c", res[i]);
    }
    printf("\n");

    assert(strcmp(res, expected) == 0);

    free(res);
}

// Example 2:

// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b
// word2:    p   q   r   s
// merged: a p b q   r   s
void example2()
{
    char *word1 = "ab";
    char *word2 = "pqrs";
    char *expected = "apbqrs";

    int word1Len = 2;
    int word2Len = 4;

    char *res = mergeAlternately(word1, word2);

    for (int i = 0; i < word1Len + word2Len; i++)
    {
        printf("%c", res[i]);
    }
    printf("\n");

    assert(strcmp(res, expected) == 0);

    free(res);
}
// Example 3:

// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q
// merged: a p b q c   d
void example3()
{
    char *word1 = "abcd";
    char *word2 = "pq";
    char *expected = "apbqcd";

    int word1Len = 4;
    int word2Len = 2;

    char *res = mergeAlternately(word1, word2);

    for (int i = 0; i < word1Len + word2Len; i++)
    {
        printf("%c", res[i]);
    }
    printf("\n");

    assert(strcmp(res, expected) == 0);

    free(res);
}
