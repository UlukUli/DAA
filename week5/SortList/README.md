# 148. Sort List

## 1. Problem

The task is to sort a singly linked list in ascending order.

Each node contains an integer value and a reference to the next node. The goal is to return the head of the sorted list.

For example:

Input: `[4, 2, 1, 3]`

Output: `[1, 2, 3, 4]`

The list can be empty, contain negative numbers, or have duplicate values.

## 2. Approach

I used the Merge Sort algorithm.

Merge Sort is suitable for linked lists because I can divide the list and combine sorted parts by changing the links between nodes.

My solution has three main steps:

1. Find the middle of the list using two pointers.
2. Split the list into two smaller lists and sort them recursively.
3. Merge the sorted lists by comparing their node values.

I use two pointers called `slow` and `fast`.

The `slow` pointer moves one node at a time, while the `fast` pointer moves two nodes at a time. When the fast pointer reaches the end, the slow pointer identifies the middle area of the list.

I then disconnect the first half from the second half and sort each part recursively.

Finally, I merge the two sorted lists. I change the node references instead of creating a new node for every element.

### Written Tracing

Consider this example:

`head = [4, 2, 1, 3]`

**Step 1: Find the middle.**

Initially:

`slow = 4`

`fast = 4`

Both pointers start at the first node.

After one iteration:

* `slow` moves to `2`.
* `fast` moves to `1`.

After another iteration:

* `slow` moves to `1`.
* `fast` moves beyond the last node.

The middle is found. The list is divided into:

Left: `[4, 2]`

Right: `[1, 3]`

**Step 2: Divide the left half.**

The left list is:

`[4, 2]`

I find its middle and split it into:

`[4]` and `[2]`

Both lists contain one node, so they are already sorted.

I merge them:

Compare `4` and `2`. Since `2` is smaller, it comes first.

Result:

`[2, 4]`

**Step 3: Divide the right half.**

The right list is:

`[1, 3]`

I split it into:

`[1]` and `[3]`

Both parts are already sorted.

After merging them, the result is:

`[1, 3]`

**Step 4: Merge both sorted halves.**

Now I have:

Left: `[2, 4]`

Right: `[1, 3]`

I compare the node values one by one:

* Compare `2` and `1`. Choose `1`.
* Compare `2` and `3`. Choose `2`.
* Compare `4` and `3`. Choose `3`.
* The right list is empty, so I attach the remaining node `4`.

The final sorted list is:

`[1, 2, 3, 4]`

### Challenges and Testing

One challenge was finding the middle of a linked list. Unlike an array, a linked list does not provide direct access to an element by its index.

I solved this problem using the slow and fast pointer technique. It allows me to find the middle without first calculating the length of the list.

Another challenge was splitting the list correctly. I needed to set `prev.next = null` to disconnect the first half from the second half. Without this step, the recursive calls could continue working with overlapping lists and fail to make progress.

I also needed to handle empty lists and lists containing only one node. These cases are handled by the base condition:

`if (head == null || head.next == null)`

I would test the solution with:

* An empty list: `[]`
* A single node: `[5]`
* Two nodes in reverse order: `[2, 1]`
* A reverse-sorted list: `[5, 4, 3, 2, 1]`
* Negative and positive numbers: `[-1, 5, 3, 4, 0]`
* Duplicate values: `[3, 1, 2, 1]`

These tests help verify that the algorithm handles different list sizes and value combinations.

## 3. Time Complexity

**Time Complexity: O(n log n)**

Here, `n` is the number of nodes in the linked list.

Finding the middle requires traversing the list, which takes `O(n)` time at each level of recursion.

The list is divided into two approximately equal parts. Therefore, there are approximately `log n` levels of division.

Merging the two sorted halves requires linear time relative to the total number of nodes being merged.

At each level, the total work is `O(n)`. With approximately `log n` levels, the total complexity is:

`O(n log n)`

This time complexity applies to the best, average, and worst cases.

## 4. Space Complexity

**Auxiliary Space Complexity: O(log n)**

The algorithm recursively divides the linked list into smaller parts.

Because each division approximately halves the list, the maximum recursion depth is `O(log n)`.

The merge operation reuses the existing nodes and does not create a separate array to store all the values.

However, the recursive function calls require stack memory. Therefore, the total auxiliary space complexity is `O(log n)`.

This solution does not achieve the strict `O(1)` auxiliary space requirement mentioned in the follow-up question.

## 5. Reflection / Improvement

A possible improvement is to implement an iterative, bottom-up Merge Sort.

Instead of recursively dividing the list, the algorithm would first merge adjacent groups of one node, then groups of two nodes, then groups of four nodes, and continue until the entire list is sorted.

This approach avoids recursive function calls.

The improved solution can achieve:

* Time Complexity: `O(n log n)`
* Auxiliary Space Complexity: `O(1)`

To implement it, I would replace the recursive splitting process with an iterative process that merges groups of increasing size.

My current solution is easier to understand because it follows the divide-and-conquer approach directly. The iterative version would be more suitable if constant auxiliary memory were required.
