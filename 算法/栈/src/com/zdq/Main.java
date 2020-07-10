package com.zdq;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        String s  = "())";
//        System.out.println(new Solution().minRemoveToMakeValid(s));

        int[] nums = {1,3,-1,-3,5,3,6,7};
        Integer[] nums2 = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
         int k = 3;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(nums2));
        for (int i = 0; i < list.size()-k+1; i++) {
            ArrayList<Integer> subList = new ArrayList(list.subList(i,i + k));
            subList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return (int)o1 - (int)o2;
                }
            });
            result.add(subList.get(subList.size()-1));
        }

        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
    }
}
