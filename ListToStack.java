import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListToStack {
    LinkedList<Integer>  list1=new LinkedList<>();
    LinkedList<Integer>  list2=new LinkedList<>();


    public static  void main(String[] args){
        ListToStack  listToStack=new ListToStack();
        listToStack.push(1);
        System.out.println(listToStack.pop());
        listToStack.push(2);
        listToStack.push(3);
        listToStack.push(4);
        listToStack.push(5);
        System.out.println(listToStack.pop());
        System.out.println(listToStack.pop());
        System.out.println(listToStack.pop());
        System.out.println(listToStack.pop());
    }

    public void push(int node) {
        list1.add(node);
    }
    public int pop() {
        while (!list1.isEmpty()){
            list2.add(list1.removeFirst());
        }
        int result=list2.removeLast();
        while (!list2.isEmpty()){
            list1.add(list2.removeFirst());
        }
        return result;
    }

}
