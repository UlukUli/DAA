
import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesA = new HashSet<>();

        ListNode current = headA;

        while (current != null) {
            nodesA.add(current);
            current = current.next;
        }

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
