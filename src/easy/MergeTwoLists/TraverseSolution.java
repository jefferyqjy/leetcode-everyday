package easy.MergeTwoLists;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/9/8 16:59
 */
public class TraverseSolution {

    public static void main(String[] args) {
        ListNode l1 = MySolution.transferArrayToListNode(new int[]{1, 2, 3});
        ListNode l2 = MySolution.transferArrayToListNode(new int[]{1, 3, 4});
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
