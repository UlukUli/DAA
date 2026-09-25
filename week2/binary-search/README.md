Binary Search
1. Problem
2. The task is to find a target value in a sorted array of integers.
If the target exists in the array, I need to return its index. If it does not exist, I return -1.

For example:
nums = [-1, 0, 3, 5, 9, 12]
target = 9

Output: 4

The value 9 is at index 4.

2. Approach
Initial Approach

My first approach was to use a simple linear search.
I would start from the first element of the array and check each element one by one until I found the target.
The basic idea would be:

Start at index 0
Check nums[0]
Check nums[1]
Check nums[2]
...

If the target is found, I return its index. If I reach the end without finding it, I return -1.
This approach is easy to understand, but it does not take advantage of the fact that the array is sorted.

Improved Approach

I improved the solution by using binary search.
I keep two variables:

left — the beginning of the current search range.
right — the end of the current search range.
I calculate the middle position:

int mid = left + (right - left) / 2;

Then I compare nums[mid] with the target.
If nums[mid] == target, I return mid.
If nums[mid] < target, the target must be to the right, so I set left = mid + 1.
If nums[mid] > target, the target must be to the left, so I set right = mid - 1.

I continue until the target is found or the search range becomes empty.

For example:

nums = [-1, 0, 3, 5, 9, 12]
target = 9

The middle value is 3.
Since 3 < 9, I know that 9 cannot be in the left half, so I search only the right half.
Then the middle value of the remaining range is 9, so I return index 4.

3. Time Complexity
Initial Approach

Time Complexity: O(n)
In the worst case, the target could be the last element of the array or could not exist at all.
Therefore, the algorithm may need to check all n elements.

For example, if there are 100 elements, the algorithm could perform up to 100 checks.
Therefore:
O(n)

Improved Approach

Time Complexity: O(log n)
Binary search eliminates approximately half of the remaining elements after every comparison.
The search space changes approximately like this:

n
n / 2
n / 4
n / 8
...

Because the search space is divided by two at each step, the number of operations grows logarithmically.
Therefore:

O(log n)

4. Space Complexity

Space Complexity: O(1)
The algorithm only uses a few variables:

left
right
mid

It does not create another array or data structure.
Therefore, the additional space used does not depend on the size of the input.
The space complexity is:

O(1)

5. Reflection / Improvement

My initial solution could solve the problem using a simple linear search, but it would take O(n) time.
The important observation is that the input array is already sorted. Because of this, I can use binary search to eliminate half of the remaining elements after each comparison.
The improvement changes the time complexity from:
O(n)
to:
O(log n)

The space complexity remains:
O(1)

The main lesson from this problem is that understanding the properties of the input can lead to a much more efficient algorithm.
Instead of checking every element, binary search uses the sorted order to quickly reduce the search area.

Conclusion

The final solution uses binary search because the array is sorted.
The final complexity is:

Time:  O(log n)
Space: O(1)

The initial linear-search approach helped me understand the basic problem, while the improved binary-search approach takes advantage of the sorted input and is much more efficient.
