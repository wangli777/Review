package com.wangli.review.demo;


/**
 * @author bg395819
 * @date 21/4/29 15:14
 * @description
 */
public class Solution {
    public ListNode1 reverseList(ListNode1 head) {
        ListNode1 current = head;
        ListNode1 prev = null;
        while (current != null) {
            ListNode1 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode1 reverseList2(ListNode1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode1 last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1() {
        }

        ListNode1(int val) {
            this.val = val;
        }

        ListNode1(int val, ListNode1 next) {
            this.val = val;
            this.next = next;
        }
    }
}
