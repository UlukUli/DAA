
import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesA = new HashSet<>();

        ListNode current = headA;

        // Store all nodes from list A
        while (current != null) {
            nodesA.add(current);
            current = current.next;
        }

        // Check nodes from list B
        current = headB;

        while (current != null) {
            if (nodesA.contains(current)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }
}
