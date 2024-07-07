public class StackToList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public static  void main(String[] args){
     Solution2  solution2=new Solution2();
     solution2.push(2);
     solution2.push(3);
     System.out.println(solution2.pop());
     solution2.push(1);
     System.out.println(solution2.pop());
     System.out.println(solution2.pop());
    }

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

}
