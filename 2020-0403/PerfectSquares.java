package day0403;


import javafx.util.Pair;

import java.util.LinkedList;

/**
 * leetcode 279 给出一个正整数n，寻找最少的完全平方数，使得他们的和为n
 * Google
 * 完全平方数 1，4，9，16...
 * 12 = 4+4+4
 * 13 = 4+9
 */
public class PerfectSquares {
    /**
     * BFS解决图中的最短路径问题
     * 对问题建模，整个问题转化为一个图论问题。
     * 从n到0，每个数字表示一个节点，
     * 如果两个数字x到y相差一个完全平方数，则连接一条边。则得到了一个无权图。
     * 原问题转化成，求这个无权图从n到0的最短路径
     */


    // 使用visited数组,记录每一个入队元素
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)

    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            for(int i = 1 ; num - i*i >= 0 ; i ++)
                if(!visited[num - i * i]){
                    queue.addLast(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new PerfectSquares()).numSquares(12));
        System.out.println((new PerfectSquares()).numSquares(13));
    }

}
