package MergeTwoLists;

/**
 * @description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author: jefferyqjy
 * @datetime: 2021/9/8 14:32
 */
public class MySolution {

    public static void main(String[] args) {
        ListNode l1 = transferArrayToListNode(new int[]{1, 2, 4});
        ListNode l2 = transferArrayToListNode(new int[]{1, 3, 4});
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 把ListNode转成数组
     * @param node
     * @return
     */
    public static int[] transferListNodeToArray(ListNode node) {
        if (node == null) {
            return null;
        }

        int length = 1;
        ListNode tmp = node;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        int i = 0;
        int[] array = new int[length];
        while (node != null) {
            array[i] = node.val;
            node = node.next;
            i++;
        }
        return array;
    }

    /**
     * 把数组转成ListNode
     * @param array
     * @return
     */
    public static ListNode transferArrayToListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int i = 0;
        ListNode node = new ListNode(array[i]);
        generateNext(node, array, ++i);
        return node;
    }

    /**
     * 遍历填充next节点
     * @param parentNode
     * @param array
     * @param index
     */
    public static void generateNext(ListNode parentNode, int[] array, int index) {
        if (index < array.length) {
            ListNode nextNode = new ListNode(array[index]);
            parentNode.next = nextNode;
            generateNext(nextNode, array, ++index);
        }
    }

    /**
     * 合并两个ListNode
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        int[] a1 = transferListNodeToArray(l1);
        int[] a2 = transferListNodeToArray(l2);

        int i = 0;
        int j = 0;
        int[] s = new int[a1.length + a2.length];
        int k = 0;
        while (i < a1.length && j < a2.length) {
            int m1 = a1[i];
            int m2 = a2[j];
            if (m1 <= m2) {
                s[k] = m1;
                i++;
            } else {
                s[k] = m2;
                j++;
            }
            k++;
        }
        if (i < a1.length) {
            for (int p = i; p < a1.length; p++) {
                s[k] = a1[p];
                k++;
            }
        }
        if (j < a2.length) {
            for (int p = j; p < a2.length; p++) {
                s[k] = a2[p];
                k++;
            }
        }
        return transferArrayToListNode(s);
    }

}
