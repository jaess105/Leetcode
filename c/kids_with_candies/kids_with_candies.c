#include <assert.h>
#include <stdio.h>

#include <stdbool.h>
#include <stdlib.h>

/// There are n kids with candies. You are given an integer array candies,
/// where each candies[i] represents the number of candies the ith kid has,
/// and an integer extraCandies, denoting the number of extra candies that you have.
/// Return a boolean array result of length n, where result[i] is true if,
/// after giving the ith kid all the extraCandies, they will have the greatest number
/// of candies among all the kids, or false otherwise.
///
/// Note that multiple kids can have the greatest number of candies.
///
/// Note: The returned array must be malloced, assume caller calls free().
bool *kidsWithCandies(int *candies, int candiesSize, int extraCandies, int *returnSize)
{
    int max = 0;
    for (size_t i = 0; i < candiesSize; i++)
    {
        if (candies[i] > max)
        {
            max = candies[i];
        }
    }

    *returnSize = candiesSize;
    bool *hasMostCandies = malloc(*returnSize * sizeof(bool));
    for (size_t i = 0; i < *returnSize; i++)
    {
        hasMostCandies[i] = candies[i] + extraCandies >= max
                                ? true
                                : false;
    }

    return hasMostCandies;
}

void example1();
void example2();
void example3();
bool arrCmp(bool *arr1, size_t arr1Len, bool *arr2, size_t arr2Len);

int main(int argc, char const *argv[])
{
    printf("Exmaple 1\n");
    example1();
    printf("Example 2\n");
    example2();
    printf("Example 3\n");
    example3();

    return 0;
}

// Example 1:

// Input: candies = [2,3,5,1,3], extraCandies = 3
// Output: [true,true,true,false,true]
// Explanation: If you give all extraCandies to:
// - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
// - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
// - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
// - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
// - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.

void example1()
{
    int candies[] = {2, 3, 5, 1, 3};
    int candiesSize = 5;
    int extraCandies = 3;
    int *returnSize = malloc(sizeof(int));

    bool expected[] = {true, true, true, false, true};
    int expectedLen = candiesSize;

    bool *hasMostCandies = kidsWithCandies(candies, candiesSize, extraCandies, returnSize);

    // printf("%s\n", hasMostCandies);

    assert(arrCmp(hasMostCandies, *returnSize, expected, expectedLen) == true);

    free(hasMostCandies);
    free(returnSize);
}

// Example 2:

// Input: candies = [4,2,1,1,2], extraCandies = 1
// Output: [true,false,false,false,false]
// Explanation: There is only 1 extra candy.
// Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
void example2()
{
    int candies[] = {2, 3, 5, 1, 3};
    int candiesSize = 5;
    int extraCandies = 3;
    int *returnSize = malloc(sizeof(int));

    bool expected[] = {true, true, true, false, true};
    int expectedLen = candiesSize;

    bool *hasMostCandies = kidsWithCandies(candies, candiesSize, extraCandies, returnSize);

    // printf("%s\n", hasMostCandies);

    assert(arrCmp(hasMostCandies, *returnSize, expected, expectedLen) == true);

    free(hasMostCandies);
    free(returnSize);
}
// Example 3:

// Input: candies = [12,1,12], extraCandies = 10
// Output: [true,false,true]

void example3()
{
    int candies[] = {2, 3, 5, 1, 3};
    int candiesSize = 5;
    int extraCandies = 3;
    int *returnSize = malloc(sizeof(int));

    bool expected[] = {true, true, true, false, true};
    int expectedLen = candiesSize;

    bool *hasMostCandies = kidsWithCandies(candies, candiesSize, extraCandies, returnSize);

    assert(arrCmp(hasMostCandies, *returnSize, expected, expectedLen) == true);

    free(hasMostCandies);
    free(returnSize);
}

// Constraints:

//     n == candies.length
//     2 <= n <= 100
//     1 <= candies[i] <= 100
//     1 <= extraCandies <= 50

bool arrCmp(bool *arr1, size_t arr1Len, bool *arr2, size_t arr2Len)
{
    printf("arr1len %lu, arr2len %lu\n", arr1Len, arr2Len);
    if (arr1Len != arr2Len)
    {
        return false;
    }

    for (size_t i = 0; i < arr1Len; i++)
    {
        printf("%lu arr1 %d, arr2 %d\n", i, arr1[i], arr2[i]);
        if (arr1[i] != arr2[i])
        {
            return false;
        }
    }

    return true;
}