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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int max = Integer.MIN_VALUE;
        int n = arr.size();
        for(int i=0; i<=(n/2)-1; i++){
            int sum = arr.get(i) + arr.get(n-1-i);
            max = Math.max(max, sum);
        }
        return max;
    }
}