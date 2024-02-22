#include <stdio.h>
#include <assert.h>

#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

char *reverseWords(char *string)
{
    int strLen = strlen(string);
    char *copy = malloc((strLen + 1) * sizeof(char));

    char *nextWordStart = copy;
    for (char *wordStart = &string[strLen - 1], *wordEnd = wordStart;
         wordStart >= string;
         wordEnd = wordStart)
    {
        for (; wordEnd >= string && *wordEnd == ' '; wordEnd--)
            ;
        if (wordEnd < string)
        {
            break;
        }

        for (wordStart = wordEnd; wordStart >= string && *wordStart != ' '; wordStart--)
            ;

        for (char *c = wordStart + 1; c <= wordEnd; c++, nextWordStart++)
        {
            *nextWordStart = *c;
        }

        *(nextWordStart++) = ' ';
    }

    *(nextWordStart - 1) = '\0';
    return copy;
}

void test(char *input, char *expected)
{
    char *res = reverseWords(input);
    printf("result: %s; expected %s\n", res, expected);
    assert(strcmp(res, expected) == 0);
    free(res);
}

int main(int argc, char const *argv[])
{
    test("the sky is blue", "blue is sky the");
    test("  hello world  ", "world hello");

    test("a good   example", "example good a");
    test("a", "a");
    return 0;
}
