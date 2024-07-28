 /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null||k==0) {
            return null;
        }
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode current = pHead;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
        if (stack.size() < k) {
            return null;
        }
        int curIndex = 1;
        while (stack.size() != 0 && curIndex < k) {
            stack.pop();
            curIndex++;
        }
        return  stack.pop();
    }
