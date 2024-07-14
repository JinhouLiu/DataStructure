package org.example;

import java.util.ArrayList;
import java.util.List;

public class NQueueProblem {


    public  static  void main(String[] args){
        //9皇后问题
        int  N=5;
        NQueueProblem  problem=new NQueueProblem();
        List<List<String>>  solutions=problem.resolveQueue(N);
        problem.printSolutions(solutions);
    }


    public List<List<String>> resolveQueue(int n){
        List<List<String>>  solutions=new ArrayList<>();
        int[] queens = new int[n]; // 用于存储每行皇后的位置
        resolve(solutions, queens, 0, n);
        return solutions;
    }

    /**
     * 检查是否能够构成N皇后
     * @param resultList
     * @param queues
     * @param row
     * @param n
     */
    public  void  resolve(List<List<String>> resultList,int[] queues,int row,int n){
        if(row==n){
            resultList.add(generateBoard(queues,n));
        }
        for(int col=0;col<n;col++){
            if(isValid(queues,row,col,n)){
                queues[row]=col;
                resolve(resultList,queues,row+1,n);
                //为了回溯
                queues[row]=-1;
            }
        }

    }


    /**
     * 检查位置是否放置皇后冲突
     * @param queue queue[i]表示第i行皇后所在列数
     * @param row   表示要放置新皇后行数
     * @param col    表示要放置新换后列数
     * @param n      指棋盘大小，也指要放置皇后个数
     * @return
     */
    public boolean isValid(int[] queue,int row,int col,int n){
        for(int i=0;i<row;i++){
            if(queue[i]==col||Math.abs(queue[i]-col)==Math.abs(i-row)){
                return  false;
            }
        }
        return true;
    }

    /**
     * 产生N皇后的一种方案
     * @param queens
     * @param n
     * @return
     */
    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /**
     * 打印N皇后问题
     * @param solutions
     */
    private  void printSolutions(List<List<String>> solutions) {
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
