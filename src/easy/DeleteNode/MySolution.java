package easy.DeleteNode;

/**
 * @description: 题目链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author: jefferyqjy
 * @datetime: 2021/11/2 11:47
 */
public class MySolution {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
