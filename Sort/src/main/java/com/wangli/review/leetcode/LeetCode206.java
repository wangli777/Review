package com.wangli.review.leetcode;

/**
 * @author bg395819
 * @date 21/4/28 15:54
 * @description 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode currentNode = node1;
//        while (currentNode != null) {
//            System.out.println(currentNode.val);
//            currentNode =  currentNode.next;
//        }
//        ListNode node =  reverseList(node1);
//        ListNode node =  reverse(node1);
//        ListNode node =  reverse1(node1);
        ListNode node = reverse2(node1);
//        ListNode node = node1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * @param head
     * @return 题解：
     * 遍历每个节点时，将当前节点的指针指向前一个节点
     * 需要两个变量，prev：存储前一个节点，current：当前节点，用于遍历链表
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            //拿到下一个节点
            ListNode next = current.next;
            //将当前节点的指针指向前一个节点，如果是第一个节点，则指向null
            current.next = prev;
            //将当前节点设置为前一个节点
            prev = current;
            //将下一个节点设置为当前节点
            current = next;

        }
        return prev;
    }

    /**
     * @param head
     * @return 解释：
     * 输入：head = [1,2,3,4,5]
     * 先从reverse(5)来看，reverse(5)返回5这个节点，给reverse(4)方法
     * 此时head为4，4.next.next = 4相当于5.next = 4，
     * 实现了反转，此时4->5, 5->4,导致循环，
     * 所以将4.next设置为null，此时prev = 5->4->null
     * 返回prev给reverse(3)方法，此时head = 3,3.next.next = 3,相当于将4->3
     * 此时3->4，所以将3.next = null，此时prev=5->4->3->null
     * 以此类推，最终得到5->4->3->2->1->null
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return prev;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存前一个节点
        ListNode prev = null;
        //当前节点
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = reverse2(head.next);

        head.next.next = head;
        head.next = null;
        return prev;
    }
}
