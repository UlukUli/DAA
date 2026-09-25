First Bad Version
1. Problem

The task is to find the first bad version among versions numbered from 1 to n.
There is an API called isBadVersion(version) that tells whether a particular version is bad.
The important property is that once a version becomes bad, every version after it is also bad.

For example:

Version:  1  2  3  4  5
Status:   G  G  G  B  B
                  ↑
             first bad

The goal is to find the first bad version.

2. Approach
Initial Approach

My first solution was a simple linear search.
I started with version 1 and checked every version one by one.

The idea was:

Check version 1
Check version 2
Check version 3
...

As soon as isBadVersion(version) returned true, I returned that version.
For example, if:

n = 5
bad version = 4

The algorithm would make these calls:

isBadVersion(1) → false
isBadVersion(2) → false
isBadVersion(3) → false
isBadVersion(4) → true

Then it returns 4.

The Java implementation of this first approach was:

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        for (int version = 1; version <= n; version++) {
            if (isBadVersion(version)) {
                return version;
            }
        }

        return -1;
    }
}

Problem With the Initial Approach

The linear solution works for small inputs, but it becomes very slow when n is very large.
For example, one of the test cases was:

n = 2126753390
bad = 1702766719

In this case, the linear search could make more than 1.7 billion API calls before finding the first bad version.

The solution received:

Time Limit Exceeded
11 / 24 testcases passed

This showed that although the initial solution was logically correct, it was not efficient enough for large inputs.

Improved Approach

I then improved the solution using binary search.
The versions always have this pattern:

Good Good Good Good Bad Bad Bad
                    ↑
               first bad

Because all versions after the first bad version are also bad, I can use the result of isBadVersion(mid) to eliminate half of the search range.
I use two variables:

left — the beginning of the search range.
right — the end of the search range.

I calculate the middle version:

int mid = left + (right - left) / 2;

Then:

If isBadVersion(mid) is true, mid could be the first bad version, so I search the left side by setting right = mid.
If isBadVersion(mid) is false, mid is definitely not bad, so the first bad version must be after it. I set left = mid + 1.
When left and right become equal, that version is the first bad version.

The improved solution is:

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

3. Time Complexity
Initial Approach

Time Complexity: O(n)
The linear search checks versions one by one.
In the worst case, the first bad version could be n.

For example:

n = 5
bad = 5

The algorithm would need to check:

1 → 2 → 3 → 4 → 5

Therefore, in the worst case, there can be n API calls.
The time complexity is:

O(n)

Improved Approach

Time Complexity: O(log n)
The binary search eliminates approximately half of the remaining versions after every API call.
The search space becomes approximately:

n
n / 2
n / 4
n / 8
...

Therefore, the number of API calls grows logarithmically.
For the large test case:

n = 2,126,753,390

binary search requires only around:

log₂(n) ≈ 31

checks instead of potentially billions of checks.

Therefore:

O(log n)

4. Space Complexity

Space Complexity: O(1)

The improved solution only uses three variables:

left
right
mid

No additional array, list, or other data structure is created.
Therefore, the additional space does not depend on n.
The space complexity is:

O(1)

5. Reflection / Improvement

My initial solution used linear search.
It was simple and easy to understand, but the test case with a very large number of versions caused a Time Limit Exceeded error.
The main problem was that the algorithm checked versions one by one.
The important observation is that the versions have a predictable pattern:

Good Good Good Bad Bad Bad

Once a version is bad, every version after it is also bad.
This property makes binary search possible.

The improvement changes the time complexity from:

O(n)
to:
O(log n)

The space complexity remains:

O(1)

The main lesson from this problem is that an initially correct solution may still be inefficient. After testing the first solution with a large input, I could identify the performance problem and improve the algorithm by using the structure of the data.

Conclusion

The initial linear-search solution was useful for understanding the problem, but it was not efficient enough for large inputs.
The final solution uses binary search and has:

Time:  O(log n)
Space: O(1)

The improvement comes from using the fact that once a version is bad, all following versions are also bad.
