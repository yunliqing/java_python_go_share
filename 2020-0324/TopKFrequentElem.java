package day0324;

import javafx.util.Pair;

import java.util.*;

public class TopKFrequentElem {
    /**
     * leetcode 347 Top K Frequent Elements
     * Pocketems yelp
     * 给定一个长度为n的非空数组，返回前k个出现频率最高的元素。
     */

    /**
     * 思路1：扫描一遍统计频率，排序找到前k个出现频率最高的元素。O(nlogn)
     */

    /**
     * 思路2：维护一个含有k个元素的优先队列。如果遍历到的元素比队列中的最小频率元素的频率高，则取出队列中最小频率的元素，
     * 将新元素入队列。最终队列中剩下的就是前k个出现频率最高的元素。O(nlogk)
     */
    public List<Integer> topKFrequent(int[] arr, int k){
        assert k > 0;
        // 统计每个元素出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }

        // 创建长度为k的优先队列，存放频率最高的数字；优先队列按照频率排序，包含的元素是（频率，元素）
        PriorityQueue<Pair<Integer, Integer>> pairs = new PriorityQueue<>(new PairComparator());
        for(Integer elem:map.keySet()){
            Integer freq = map.get(elem);
            if(pairs.size() == k){
                // 若当前元素的频率比优先队列中最小的频率要大，则将其挤出来
                if(freq > pairs.peek().getKey()){
                    pairs.poll();
                    pairs.add(new Pair<>(freq, elem));
                }
            }else
                pairs.add(new Pair<>(freq, elem));

        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pairs.isEmpty())
            list.add(pairs.poll().getValue());
        return list;
    }

    /**
     * 内部类自定义对pair的排序
     */
    private class PairComparator implements Comparator<Pair<Integer,Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            if(p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new TopKFrequentElem()).topKFrequent(nums, k));
    }


}
