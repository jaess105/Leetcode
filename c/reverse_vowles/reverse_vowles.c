#include <stdio.h>
#include <assert.h>

#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define ALPHABET_LENGTH 26

bool *construct_alphabet_arr()
{
    static bool alphabet[ALPHABET_LENGTH];

    alphabet['a' - 'a'] = true;
    alphabet['e' - 'a'] = true;
    alphabet['i' - 'a'] = true;
    alphabet['o' - 'a'] = true;
    alphabet['u' - 'a'] = true;

    return alphabet;
}

bool is_not_vowle(bool *alphabet, char c)
{
    int index = tolower(c) - 'a';
    return index < 0 || index >= ALPHABET_LENGTH || !alphabet[index];
}

char *reverseVowels(char *string)
{
    bool *alphabet = construct_alphabet_arr();

    int strLen = strlen(string);
    char *copy = malloc((strLen + 1) * sizeof(char));
    strncpy(copy, string, strLen);
    copy[strLen] = '\0';

    char *start = copy;
    char *end = &copy[strLen - 1];

    while (end > start)
    {
        while ((start + 1) <= (copy + strLen - 1) && is_not_vowle(alphabet, *start))
        {
            start++;
        }

        while ((end - 1) >= copy && is_not_vowle(alphabet, *end))
        {
            end--;
        }

        if (end <= start)
        {
            break;
        }

        char tmp = *end;
        *end = *start;
        *start = tmp;

        start++;
        end--;
    }

    return copy;
}

void test(char *input, char *expected)
{
    char *res = reverseVowels(input);
    printf("result: %s; expected %s\n", res, expected);
    assert(strcmp(res, expected) == 0);
    free(res);
}

int main(int argc, char const *argv[])
{
    test("hello", "holle");
    test("leetcode", "leotcede");

    test("a.", "a.");
    test("a a", "a a");

    test("a.b,.", "a.b,.");

    return 0;
}
