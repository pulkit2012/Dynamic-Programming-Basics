package Memoization;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HowSum {
    static ArrayList<Integer> howSum2(int target, int[] arr, HashMap<Integer, ArrayList<Integer>> map){
        if(map.containsKey(target)){
            return map.get(target);
        }
        if(target == 0){
            return new ArrayList<>();
        }
        if(target < 0){
            return null;
        }
        for(int i : arr){
            int remainder = target - i;
            ArrayList<Integer> res = howSum2(remainder,arr,map);
            if(res != null){
                res.add(i);
                map.put(target, res);
                return map.get(target);
            }
        }
        map.put(target,null);
        return null;
    }
    //simple howSum brute force
    static ArrayList<Integer> howSum(int target, int[] arr){
        if(target == 0){
            return new ArrayList<>();
        }
        if(target < 0){
            return null;
        }
        for(int i : arr){
            int remaining = target - i;
            ArrayList<Integer> res = howSum(remaining,arr);
            if(res != null){
                res.add(i);
                return res;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] arr = {2,3};
//        System.out.println(howSum(7,arr));;
//        System.out.println(howSum(7,new int[]{5,3,4,7}));
//        System.out.println(howSum(8,new int[]{2,3,5}));
        //System.out.println(howSum(300,new int[]{7,14}));
        /////////////////////////////////////////////////////////////////
        //System.out.println(howSum2(7,arr,map));;
        //System.out.println(howSum2(7,new int[]{5,3,4,7},map));
//        System.out.println(howSum2(8,new int[]{2,3,5},map));
         System.out.println(howSum2(300,new int[]{7,14},map));
    }
}
