/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = null;

            if(temp.val<x){
                dummy1.next = temp;
                dummy1 = dummy1.next;
            }
            else{
                dummy2.next = temp;
                dummy2 = dummy2.next;
            }
            temp = next;
        }
        dummy1.next = temp2.next;
        return temp1.next;

    }
}