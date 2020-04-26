package com.robin.wang.test.mytestdemo.data;

import org.junit.Test;

public class Test2 {
}

/*
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(val);
        while (next != null) {
            stringBuffer.append("->");
            stringBuffer.append(next.toString());
        }
        return stringBuffer.toString();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        boolean first = true;
        ListNode tempNode = new ListNode(0);
        int great = 0;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int temp = l1Value + l2Value + great;
            great = 0;
            if (temp > 9) {
                temp = temp - 10;
                great = 1;
            }
            tempNode = new ListNode(temp);
            if (first) {
                head = tempNode;
                first = false;
            }
            tempNode = tempNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        node2.next = node1;
        ListNode node3 = new ListNode(2);
        node3.next = node2;
        ListNode node14 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node5.next = node1;
        ListNode node6 = new ListNode(6);
        node6.next = node5;
        ListNode listNode = solution.addTwoNumbers(node3, node6);
        System.out.println(listNode);

    }
}