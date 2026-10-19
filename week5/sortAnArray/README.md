
# 912. Sort an Array

## 1. Problem

The task is to sort an array of integers in ascending order without using built-in sorting functions.

For example:

Input: `[5, 2, 3, 1]`

Output: `[1, 2, 3, 5]`

The array can contain duplicate numbers and negative values.

## 2. Approach

I used the Merge Sort algorithm.

Merge Sort follows the divide-and-conquer approach. It divides the array into smaller parts, sorts these parts, and then combines them in ascending order.

My solution has three main steps:

1. Divide the array into two halves.
2. Recursively sort both halves.
3. Merge the sorted halves into one sorted section.

I created a temporary array to store elements during merging. After merging a section, I copy the elements back into the original array.

I did not use any built-in sorting functions.

### Written Tracing

Consider this example:

`nums = [5, 2, 3, 1]`

**Step 1: Divide the array.**

The original array is:

`[5, 2, 3, 1]`

I divide it into two parts:

`[5, 2]` and `[3, 1]`

Then I divide these parts again:

`[5]`, `[2]`, `[3]`, `[1]`

Each part contains one element, so it is already sorted.

**Step 2: Merge the first pair.**

I compare `5` and `2`.

Since `2` is smaller, I place it first. Then I place `5`.

The result is:

`[2, 5]`

**Step 3: Merge the second pair.**

I compare `3` and `1`.

Since `1` is smaller, the result is:

`[1, 3]`

**Step 4: Merge the two sorted halves.**

Now I have:

Left half: `[2, 5]`

Right half: `[1, 3]`

I compare the first elements:

* Compare `2` and `1`. Choose `1`.
* Compare `2` and `3`. Choose `2`.
* Compare `5` and `3`. Choose `3`.
* The right half is empty, so I add the remaining `5`.

The final array is:

`[1, 2, 3, 5]`

### Challenges and Testing

One challenge was understanding how to merge two sorted parts without losing any elements.

At first, it is easy to focus only on comparing the first elements and forget that one part may still contain remaining elements. My solution handles this with two additional loops. They copy any remaining elements from either half.

I also needed to make sure that the temporary array was used correctly. After merging, I copy the sorted section back into the original array so that the next recursive step works with the updated values.

I would test the solution with:

* An array containing one element: `[7]`
* An already sorted array: `[1, 2, 3, 4]`
* A reverse-sorted array: `[4, 3, 2, 1]`
* Duplicate values: `[5, 1, 1, 2, 0, 0]`
* Negative numbers: `[-3, 2, -1, 0]`

These tests help check boundary conditions, duplicates, and the correct ordering of negative and positive numbers.

## 3. Time Complexity

**Time Complexity: O(n log n)**

Here, `n` is the number of elements in the array.

At each level, the algorithm divides the array into smaller parts. The number of division levels is approximately `log n`, because the size of each part is halved.

At each level, merging processes all `n` elements in total. Therefore, each level takes `O(n)` time.

There are approximately `log n` levels, so the total time complexity is:

`O(n) * O(log n) = O(n log n)`

This complexity applies to the best, average, and worst cases.

## 4. Space Complexity

**Space Complexity: O(n)** auxiliary space.

The temporary array requires `O(n)` additional memory to store elements during merging.

The recursive calls also use a stack of depth `O(log n)`. However, the temporary array is the dominant additional memory cost, so the overall auxiliary space complexity is `O(n)`.

## 5. Reflection / Improvement

A possible improvement is to use Heap Sort.

Heap Sort can sort the array in `O(n log n)` time while using `O(1)` auxiliary space when implemented in place.

To use this approach, I would replace the recursive division and merging steps with heap construction and repeated extraction of the largest element.

This would reduce additional memory usage from `O(n)` to `O(1)`, while preserving the `O(n log n)` time complexity.

I chose Merge Sort because its divide-and-conquer process is straightforward to explain and trace. However, Heap Sort would be a better choice if minimizing additional memory were the main priority.
