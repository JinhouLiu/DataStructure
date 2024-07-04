package org.example;

import java.util.Stack;

public class Solution1 {


    public static void main(String[] args){

        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        System.out.println("未翻转前链表");
        ListNode temp=listNode1;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
        System.out.println("未翻转前打印结束");


        System.out.println("翻转后链表");
       ListNode reverse= ReverseList1(listNode1);

        ListNode reverseTemp=reverse;
        while (reverseTemp!=null){
            System.out.println(reverseTemp.val);
            reverseTemp=reverseTemp.next;
        }
        System.out.println("翻转后打印结束");

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnList = new ListNode(Integer.MIN_VALUE);
        ListNode IndexNode=returnList;
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                IndexNode.next = list1;
                list1 = list1.next;

            } else {

                IndexNode.next = list2;
                list2 = list2.next;


            }
            IndexNode=IndexNode.next;
        }
        if (list1 != null) {
            IndexNode.next = list1;
        }
        if (list2 != null) {
            IndexNode.next = list2;

        }
        return returnList.next;
    }

    /**
     * 利用堆栈先进后的特点来实现，空间复杂度比较高，但比较容易实现，时间复杂度O(n),空间复杂度O(n)
     * @param head
     * @return
     */
    public static ListNode ReverseList (ListNode head) {
     if(head==null||head.next==null){
        return  head;
     }
     Stack<ListNode> stack=new Stack<>();
     while (head!=null){
         stack.add(head);
         head=head.next;
     }
     ListNode resultList=stack.pop();
     ListNode cycleNode=resultList;
     while (!stack.isEmpty()){
          cycleNode.next=stack.pop();
          cycleNode=cycleNode.next;
     }
        cycleNode.next = null;
        return resultList;
    }

    /**
     * 利用两个指针的方式来实现，一个保存前节点，一个保存后节点，不断的循环来实现这个逻辑，空间复杂度O(1),实现复杂福O(n)
     * @param head
     * @return
     */
    public static ListNode ReverseList1(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }
        ListNode  prev=null;
        ListNode  current=head;
        while (current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }
}





class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

