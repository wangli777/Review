package com.wangli.review.leetcode;


/**
 * @author bg395819
 * @date 21/6/24 17:38
 * @description
 */
public class LeetCode92 {

    /**
     * 迭代法
     */
    static class IterationSolution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //构造一个虚拟节点，指向第一个节点
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;

            //构造一个pre节点，位于left节点前，需要走left-1步
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            //构造一个right节点,从pre节点需要走right-left+1步
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

//            构造left节点
            ListNode leftNode = pre.next;
            //构造right节点后一个节点 后驱节点
            ListNode suc = rightNode.next;

            //将中间节点与原链表断开
            pre.next = null;
            rightNode.next = null;

            //翻转中间节点
//            this.reverseList(leftNode);
            this.reverse(leftNode);

            //翻转完后，将中间节点接回原链表，此时rightNode实际为左节点，
            pre.next = rightNode;
            leftNode.next = suc;

            return dummyNode.next;


        }

        private void reverseList(ListNode head) {
            //前一个节点
            ListNode prev = null;
            //当前节点
            ListNode cur = head;
            while (cur != null) {
                //先保存下一个节点
                ListNode next = cur.next;
                //当前节点的下一个节点，指向前一个节点，即翻转了
                cur.next = prev;
                //将当前节点变为前节点
                prev = cur;
                //将下一个节点变为当前节点
                cur = next;

            }
        }

        /**
         * 翻转链表
         *
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    /**
     * 递归法
     */
    static class RecursionSolution {
        public RecursionSolution() {
        }


        /**
         * 反转链表 m n之间的节点
         *
         * @param head
         * @param m
         * @param n
         * @return
         */
        private ListNode reverseMN(ListNode head, int m, int n) {
            if (m == 1) {
                //m是第一个元素时，相当于反转前n个元素
                return reverseN(head, n);
            }
            head.next = reverseMN(head.next, m - 1, n - 1);

            return head;

        }

        /**
         * 第n个元素后一个元素
         */
        private ListNode successor;

        /**
         * 反转链表前n个元素
         *
         * @param head
         * @param n
         * @return
         */
        private ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                //n节点后一个节点
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

        /**
         * 反转链表
         *
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);

            head.next.next = head;
            head.next = null;

            return last;
        }
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

}
