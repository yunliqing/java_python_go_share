package day0329;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 350 Intersection of Two Arrays
 * 给定两个数组nums，求两个数组的公共元素
 * 如nums1=[1,2,2,1],nums2=[2,2],结果为[2,2]
 * 出现的顺序可以是任意的
 */
public class MapExample {

    // 维护一个map，把第一个数组的元素放入里面，遍历第二个数组，每次遇到包含的情况，map中对应的数字次数减1
    private List<Integer> result;

    public MapExample(){
        result = new ArrayList<>();
    }

    private void getIntersection(List<Integer> nums1, List<Integer> nums2){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums1.size();i++){
            Integer elem = nums1.get(i);
            if(hashMap.keySet().contains(elem))
                hashMap.put(elem,hashMap.get(elem) + 1);
            else
                hashMap.put(elem,1);
        }
        for(int j=0;j<nums2.size();j++){
            Integer elem = nums2.get(j);
            if(hashMap.keySet().contains(elem) && hashMap.get(elem) != 0){
                result.add(elem);
                hashMap.put(elem,hashMap.get(elem) - 1);
            }
        }
    }


    public static void main(String[] args) {
        MapExample mapExample = new MapExample();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(2);
        nums1.add(1);
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(2);
        nums2.add(2);

        mapExample.getIntersection(nums1,nums2);
        System.out.println(mapExample.result);
    }

}
