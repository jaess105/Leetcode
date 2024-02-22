#include <assert.h>

#include <stdlib.h>
#include <stdbool.h>

/// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
/// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
/// return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
bool canPlaceFlowers(int *flowerbed, int flowerbedSize, int n)
{
    if (n == 0)
    {
        return true;
    }

    if (flowerbed[0] == 0 && (flowerbedSize < 2 || flowerbed[1] == 0))
    {
        *flowerbed = 1;
        --n;
        ++flowerbed;
        --flowerbedSize;
    }

    while (2 < flowerbedSize--)
    {
        if (flowerbed[0] == 0 && flowerbed[-1] == 0 && flowerbed[1] == 0)
        {
            flowerbed[0] = 1;
            --n;
        }
        flowerbed++;

        if (n == 0)
        {
            return true;
        }
    }

    if (n == 1 && flowerbedSize >= 2 && flowerbed[0] == 0 && flowerbed[-1] == 0)
    {
        return true;
    }

    return n == 0;
}

void example1();
void example2();
void example3();
void example4();

int main(int argc, char const *argv[])
{
    example1();
    example2();
    example3();
    example4();
    return 0;
}

// Example 1:

// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true

void example1()
{
    int flowerbed[] = {1, 0, 0, 0, 1};
    int flowerbedSize = 5;
    int n = 1;

    bool expected = true;

    bool res = canPlaceFlowers(flowerbed, flowerbedSize, n);

    assert(res == expected);
}

// Example 2:

// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
void example2()
{
    int flowerbed[] = {1, 0, 0, 0, 1};
    int flowerbedSize = 5;
    int n = 2;

    bool expected = false;

    bool res = canPlaceFlowers(flowerbed, flowerbedSize, n);

    assert(res == expected);
}

void example3()
{
    int flowerbed[] = {0};
    int flowerbedSize = 1;
    int n = 1;

    bool expected = true;

    bool res = canPlaceFlowers(flowerbed, flowerbedSize, n);

    assert(res == expected);
}

void example4()
{
    int flowerbed[] = {1, 0, 0, 0, 1, 0, 0};
    int flowerbedSize = 7;
    int n = 2;

    bool expected = true;

    bool res = canPlaceFlowers(flowerbed, flowerbedSize, n);

    assert(res == expected);
}