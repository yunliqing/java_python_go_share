package day0329;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 349 Intersection of Two Arrays
 * TWO SIGMA
 * 给定两个数组nums，求两个数组的公共元素
 * 如nums1=[1,2,2,1],nums2=[2,2],结果为2，结果中每个元素只能出现一次
 * 出现的顺序可以是任意的
 */
public class SetExample {

    // 维护两个set,一个保存第一个数组，一个保存结果
    private Set<Integer> result;

    public SetExample(){
        result = new HashSet<Integer>();
    }

    private void getIntersection(List<Integer> nums1, List<Integer> nums2){
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0;i<nums1.size();i++){
            hashSet.add(nums1.get(i));
        }

        for(int j=0;j<nums2.size();j++){
            if(hashSet.contains(nums2.get(j)))
                result.add(nums2.get(j));
        }
    }


    public static void main(String[] args) {
        SetExample setExample = new SetExample();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(2);
        nums1.add(1);
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(2);
        nums2.add(2);

        setExample.getIntersection(nums1,nums2);
        System.out.println(setExample.result);
    }

}
