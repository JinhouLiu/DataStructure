package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 排列組合问题
 */
public class PerAndComProblem {

    Stack<Integer> stack=new Stack<>();
    /**
     * 多重集排列
     * @param nums
     * @return
     */
   public ArrayList<ArrayList<Integer>> allPermute(int[] nums) {
     if(nums==null||nums.length==0){
         return null;
     }
     //对数组进行排序
     Arrays.sort(nums);
     ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
     allPermute(nums,nums.length,0,resultList);
     return resultList;
   }

    /**
     * 有重复数组的全排序
     * @param nums
     * @param length
     * @param start
     * @param resultList
     */
   public void   allPermute(int[] nums,int length,int start,ArrayList<ArrayList<Integer>> resultList){

       if(start==length){
           ArrayList<Integer>  integers=new ArrayList<>(stack);
           resultList.add(integers);
           return;
       }
       for(int i=0;i<length;i++){
           stack.add(nums[i]);
           allPermute(nums,length,start+1,resultList);
           stack.pop();
       }
   }

    /**
     * 打印结果数组
     * @param list
     */
   public void  printResultList(ArrayList<ArrayList<Integer>> list){
       for(ArrayList<Integer>  result :list){
           for(Integer  cur: result){
            System.out.print(cur+"\t");
           }
           System.out.println();
       }
   }

   public  static  void   main(String[] args){
       int[] nums={1,2,3,4};
       ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
       PerAndComProblem perAndComProblem=new PerAndComProblem();
        resultList=perAndComProblem.allPermute(nums);
        perAndComProblem.printResultList(resultList);
   }

}
