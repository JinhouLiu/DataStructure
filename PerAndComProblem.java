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
   public ArrayList<ArrayList<Integer>> allContainRepeatPermute(int[] nums) {
     if(nums==null||nums.length==0){
         return null;
     }
     //对数组进行排序
     Arrays.sort(nums);
     ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
       allContainRepeatPermute(nums,nums.length,0,resultList);
     return resultList;
   }

    /**
     * 有重复数组的全排序
     * @param nums  数组，不包含重复元素
     * @param length  数组长度
     * @param start   开始位置
     * @param resultList 返回结果
     */
   public void  allContainRepeatPermute(int[] nums,int length,int start,ArrayList<ArrayList<Integer>> resultList){

       if(start==length){
           ArrayList<Integer>  integers=new ArrayList<>(stack);
           resultList.add(integers);
           return;
       }
       for(int i=0;i<length;i++){
           stack.add(nums[i]);
           allContainRepeatPermute(nums,length,start+1,resultList);
           stack.pop();
       }
   }

    /**
     * 没有重复数字的全排列
     * @param nums
     * @return
     */
    public ArrayList<ArrayList<Integer>> allNotContainRepeatPermute(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        //对数组进行排序
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        allNotContainReapeatPermute(nums,nums.length,0,resultList);
        return resultList;
    }

    /**
     * 没有重复数字的全排列
     * @param nums 数组，不包含重复数字
     * @param length 数组长度
     * @param start 开始位置
     * @param resultList  返回结果
     */
   public void  allNotContainReapeatPermute(int[] nums,int length,int start,ArrayList<ArrayList<Integer>> resultList){
       if(start==length){
           ArrayList<Integer>  integers=new ArrayList<>(stack);
           resultList.add(integers);
           return;
       }
       for(int i=0;i<length;i++){
           if(!stack.contains(nums[i])){
               stack.add(nums[i]);
               allNotContainReapeatPermute(nums,length,start+1,resultList);
               stack.pop();
           }
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

    /**
     * 组合问题求解
     * @param nums,数组不包含重复元素
     * @return
     */
    public ArrayList<ArrayList<Integer>> allContainRepeatCombination(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        //对数组进行排序
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        allContainRepeatCombination(nums,3,0,0,resultList);
        return resultList;
    }

    /**
     * 组合问题生成的组合可能包含重复元素
     * @param nums 数组不包含重复元素
     * @param targetLength 需要选取多少个字符
     * @param start 开始位置
     * @param resultList 返回结果
     */
   public void  allContainRepeatCombination(int[] nums,int targetLength,int has,int start,ArrayList<ArrayList<Integer>> resultList){
       if(has==targetLength){
           ArrayList<Integer>  integers=new ArrayList<>(stack);
           resultList.add(integers);
           return;
       }
       for(int i=start;i< nums.length;i++){
               stack.add(nums[i]);
               allContainRepeatCombination(nums,targetLength,has+1,i,resultList);
               stack.pop();
       }
   }


    /**
     * 组合问题求解生成不包含重复元素
     * @param nums,数组不包含重复元素
     * @return
     */
    public ArrayList<ArrayList<Integer>> allNotContainRepeatCombination(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        //对数组进行排序
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        allNotContainRepeatCombination(nums,3,0,0,resultList);
        return resultList;
    }

    /**
     * 不允许重复数的组合问题
     * @param nums 数组不包含重复元素
     * @param targetLength 需要选取多少个字符
     * @param has   已经拥有多少
     * @param start 起始位置
     * @param resultList 返回结果
     */
    public void  allNotContainRepeatCombination(int[] nums,int targetLength,int has,int start,ArrayList<ArrayList<Integer>> resultList){
        if(has==targetLength){
            ArrayList<Integer>  integers=new ArrayList<>(stack);
            resultList.add(integers);
            return;
        }
        for(int i=start;i< nums.length;i++){
            stack.add(nums[i]);
            allNotContainRepeatCombination(nums,targetLength,has+1,i+1,resultList);
            stack.pop();
        }
    }


   public  static  void   main(String[] args){
       int[] nums={1,2,3,4};
       ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
       PerAndComProblem perAndComProblem=new PerAndComProblem();

//        resultList=perAndComProblem.allContainRepeatPermute(nums);
//        perAndComProblem.printResultList(resultList);

//       resultList=perAndComProblem.allNotContainRepeatPermute(nums);

//       resultList=perAndComProblem.allNotContainRepeatCombination(nums);

       resultList=perAndComProblem.allContainRepeatCombination(nums);
       perAndComProblem.printResultList(resultList);

   }

}
