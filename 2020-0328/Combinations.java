package day0328;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 * leetcode 77 Combinations
 * 给出两个整数n和k，求在1到n这n个数字中选出k个数字的所有组合
 * 如 n=4，k=2
 * 结果为[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * 时间复杂度: O(n^k)
 * 空间复杂度: O(k)
 */
public class Combinations {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        for(int i = start ; i <= n ; i ++){
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Combinations()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }

}
